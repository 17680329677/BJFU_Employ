package com.tbms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    private String mpAppToken;

    public String getMpAppAesKey() {
        return mpAppAesKey;
    }

    public void setMpAppAesKey(String mpAppAesKey) {
        this.mpAppAesKey = mpAppAesKey;
    }

    private String mpAppAesKey;


    public void setMpAppId(String mpAppId) {
        this.mpAppId = mpAppId;
    }

    public void setMpAppSecret(String mpAppSecret) {
        this.mpAppSecret = mpAppSecret;
    }

    public void setMpAppToken(String mpAppToken) {
        this.mpAppToken = mpAppToken;
    }

    public String getMpAppId() {
        return mpAppId;
    }

    public String getMpAppSecret() {
        return mpAppSecret;
    }

    public String getMpAppToken() {
        return mpAppToken;
    }
}
