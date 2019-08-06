package com.tbms.admin.shiro.config;

import com.tbms.core.common.kaptchar.CaptchaUsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 自定义Authenticator
 * 注意，当需要分别定义处理学生和教师和管理员验证的Realm时，对应Realm的全类名应该包含字符串“Student”“Teacher”，或者“Admin”。
 * 并且，他们不能相互包含，例如，处理学生验证的Realm的全类名中不应该包含字符串"Admin"。
 */
public class UserModularRealmAuthenticator extends ModularRealmAuthenticator {
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 判断getRealms()是否返回为空
        assertRealmsConfigured();
        // 强制转换回自定义的CustomizedToken
        CaptchaUsernamePasswordToken userToken = (CaptchaUsernamePasswordToken) authenticationToken;
        // 登录类型
        String loginType = userToken.getLoginType();
        // 所有Realm
        Collection<Realm> realms = getRealms();
        // 登录类型对应的所有Realm
        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if (realm.getName().contains(loginType))
                typeRealms.add(realm);
        }

        // 判断是单Realm还是多Realm
        if (typeRealms.size() == 1){
            return doSingleRealmAuthentication(typeRealms.iterator().next(), userToken);
        }
        else{
            return doMultiRealmAuthentication(typeRealms, userToken);
        }
    }
}