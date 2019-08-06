package com.tbms.core.common.kaptchar;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
    private static final long serialVersionUID = 1L;

    //验证码字符串
    private String captcha;
    //登录类型，判断是学生登录，教师登录还是管理员登录
    private String loginType;

    public CaptchaUsernamePasswordToken(String username, char[] password,
                                        boolean rememberMe, String host, String captcha,String loginType) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
        this.loginType = loginType;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
