package com.tbms.admin.controller;

import com.tbms.core.common.kaptchar.IncorrectCaptchaException;
import com.tbms.core.dto.StudentDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest req, Model model){
        Object exception = (Object) req.getAttribute("shiroLoginFailure");
        String error = null;
        if(exception!=null){
            if(UnknownAccountException.class.isInstance(exception)) {
                error = "用户名错误";
            } else if(IncorrectCredentialsException.class.isInstance(exception)) {
                error = "密码错误";
            } else if(ExcessiveAttemptsException.class.isInstance(exception)) {
                error = "登陆失败次数过多";
            } else if(IncorrectCaptchaException.class.isInstance(exception)) {
                error = "验证码错误";
            }else {
                error = "其他错误";
            }
            model.addAttribute("error", error);
            return "login";
        }else{
            String type= req.getParameter("type");
            String url;
            switch (type){
                case "Admin" :
                    url = "";
                    break;
                case "Student":
                    StudentDTO studentDTO = (StudentDTO) SecurityUtils.getSubject().getPrincipal();
                    if (studentDTO.getStatus() == -4) {
                        url = "stu/#survey";
                    } else {
                        url = "stu/";
                    }
                    break;
                default:
                    url = "";
            }
            System.out.println(url);
            return "redirect:/"+url;
        }
    }
}
