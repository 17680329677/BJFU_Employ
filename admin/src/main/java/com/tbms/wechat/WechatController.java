package com.tbms.wechat;

import com.mysql.jdbc.CacheAdapter;
import com.tbms.config.WechatAccountConfig;
import com.tbms.core.dto.StudentDTO;
import com.tbms.core.dto.TokenDTO;
import com.tbms.core.service.StudentService;
import com.tbms.core.service.TokenService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.shiro.SecurityUtils;
import org.omg.PortableInterceptor.ServerRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Resource
    private WxMpService wxMpService;
    @Resource
    private StudentService studentService;
    @Resource
    private TokenService tokenService;

    @GetMapping
    @ResponseBody
    public String doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        boolean flag = wxMpService.checkSignature(timestamp, nonce, signature);
        if (flag) {
            return echostr;
        }
        return "非法请求";
    }

    @PostMapping
    @ResponseBody
    public void getMsg(@RequestBody String requestBody, @RequestParam("signature") String signature,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature,
                       @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce,
                       HttpServletResponse response) throws IOException{
        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求！");
        }

        if (encType == null) {
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
            String msgType = inMessage.getMsgType();
            String fromUser = inMessage.getFromUser();
            String toUser = inMessage.getToUser();
            String content = inMessage.getContent();
            WxMpXmlOutMessage text = WxMpXmlOutMessage.TEXT().
                    toUser(fromUser).fromUser(toUser).content("hahahah").build();
            String xml = text.toXml();
            PrintWriter out = response.getWriter();
            out.print(xml);
            out.close();
        }
    }

    @GetMapping("/authorize")
    public String authorize(@RequestParam("url") String url,
                            @RequestParam("state") String state) throws Exception {
//        String url = "http://employ.nsoa.site/wechat/userInfo";
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(state, "UTF-8"));
        return "redirect:" + redirectURL;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String state) throws Exception {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            throw new Exception(e.getError().getErrorMsg());
        }
        String accessToken = wxMpOAuth2AccessToken.getAccessToken();
        WxMpUser user = null;
        user = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        String oppenId = wxMpOAuth2AccessToken.getOpenId();
        StudentDTO student = studentService.getStudentById(Integer.parseInt(state));
        if (student != null) {
            if (student.getBindAccount() == null || "".equals(student.getBindAccount())) {
                student.setBindAccount(oppenId);
                student.setPassword(null);  // 防止密码被修改（重置）
                studentService.updateStudent(student);
                String refreshToken = wxMpOAuth2AccessToken.getRefreshToken();
                TokenDTO token = tokenService.getTokenByStudentId(student.getId());
                if (token == null) {
                    TokenDTO newToken = new TokenDTO();
                    newToken.setAccessToken(accessToken);
                    newToken.setRefreshToken(refreshToken);
                    tokenService.addToken(newToken);
                } else {
                    token.setAccessToken(accessToken);
                    token.setRefreshToken(refreshToken);
                    token.setUpdateTime(null);
                    tokenService.updateToken(token);
                }
                WxMpKefuMessage message = WxMpKefuMessage.TEXT().toUser(oppenId).content("绑定成功！").build();
                wxMpService.getKefuService().sendKefuMessage(message);
            } else {
                WxMpKefuMessage message = WxMpKefuMessage.TEXT().toUser(oppenId).content("已绑定！").build();
                wxMpService.getKefuService().sendKefuMessage(message);
            }
        } else {
            WxMpKefuMessage message = WxMpKefuMessage.TEXT().toUser(oppenId).content("请先在PC端登录扫码授权绑定！").build();
            wxMpService.getKefuService().sendKefuMessage(message);
        }
        return "redirect:" + "/wechat/selfInfo" + "?oppenId=" + oppenId;
    }

    @GetMapping("/selfInfo")
    public String getSelfInfo(@RequestParam("oppenId") String oppenId, Model model) throws WxErrorException {
        StudentDTO student = studentService.getStudentByBindAccount(oppenId);
        WxMpKefuMessage message = WxMpKefuMessage.TEXT().toUser(oppenId)
                .content("姓名：" + student.getName()).build();
        wxMpService.getKefuService().sendKefuMessage(message);
        model.addAttribute("student", student);
        return "wechat/wechatInfo";
    }
}
