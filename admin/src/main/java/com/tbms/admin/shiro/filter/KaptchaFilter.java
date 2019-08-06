package com.tbms.admin.shiro.filter;

import com.tbms.core.common.kaptchar.CaptchaUsernamePasswordToken;
import com.tbms.core.common.kaptchar.IncorrectCaptchaException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class KaptchaFilter extends FormAuthenticationFilter {
    public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

    private String captchaParam = DEFAULT_CAPTCHA_PARAM;

    private String loginType;

    //登录验证
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response)
            throws Exception {

        CaptchaUsernamePasswordToken token = createToken(request, response);
        String username = token.getUsername();
        try {
            /*图形验证码验证*/
            doCaptchaValidate((HttpServletRequest) request, token);
            Subject subject = getSubject(request, response);
            subject.login(token);//正常验证

            //到这里就算验证成功了,把用户信息放到session中
            ((HttpServletRequest) request).getSession().setAttribute("name",username);
             return true;
        }catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }


    // 验证码校验
    protected void doCaptchaValidate(HttpServletRequest request, CaptchaUsernamePasswordToken token) {
        //session中的图形码字符串
        String captcha = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        //比对
        if (captcha == null || !captcha.equalsIgnoreCase(token.getCaptcha())) {
            throw new IncorrectCaptchaException();
        }
    }

    @Override
    protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {

        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = getCaptcha(request);
        String loginType = getLoginType(request);
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        return new CaptchaUsernamePasswordToken(username, password.toCharArray(), rememberMe, host, captcha,loginType);
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getCaptchaParam() {
        return captchaParam;
    }
    public void setCaptchaParam(String captchaParam) {
        this.captchaParam = captchaParam;
    }

    protected String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    protected String getLoginType(ServletRequest request){
        return WebUtils.getCleanParam(request,"type");
    }

    //保存异常对象到request
    @Override
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        request.setAttribute(getFailureKeyAttribute(), ae);
    }
}
