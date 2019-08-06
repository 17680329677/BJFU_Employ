package com.tbms.admin.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.tbms.admin.shiro.realm.AdminRealm;
import com.tbms.admin.shiro.realm.StudentRealm;
import com.tbms.admin.shiro.filter.KaptchaFilter;
import net.sf.ehcache.CacheManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();//new LinkedHashMap<String, Filter>();
		//验证码过滤器
		KaptchaFilter kaptchaFilter = new KaptchaFilter();
		filters.put("kaptchar", kaptchaFilter);

		shiroFilterFactoryBean.setFilters(filters);

		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setUnauthorizedUrl("/exception");
		
		Map<String, String> filterChain = new LinkedHashMap<>();

		filterChain.put("/system/kaptchar", "anon");
		filterChain.put("/bower_components/**", "anon");
		filterChain.put("/css/**", "anon");
		filterChain.put("/img/**", "anon");
		filterChain.put("/js/**", "anon");
		filterChain.put("/plugins/**", "anon");
		filterChain.put("/wechat/**", "anon");
		filterChain.put("/question/static/**", "anon");
		filterChain.put("/login", "kaptchar");
		filterChain.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChain);
		return shiroFilterFactoryBean;
	}

	@Bean
	public DefaultWebSecurityManager getSecurityManager(CookieRememberMeManager cookieRememberMeManager) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRememberMeManager(cookieRememberMeManager);
		//设置realm.
		defaultWebSecurityManager.setAuthenticator(modularRealmAuthenticator());
		//添加多个Realm
		List<Realm> realms = new ArrayList<>();
		realms.add(adminRealm());
		realms.add(studentRealm());
		defaultWebSecurityManager.setRealms(realms);
		return defaultWebSecurityManager;
	}

	/**
	 * 系统自带的Realm管理，主要针对多realm
	 * */
	@Bean
	public ModularRealmAuthenticator modularRealmAuthenticator(){
		UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
		modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
		return modularRealmAuthenticator;
	}

	/**
	 * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
	 */
	@Bean
	public AdminRealm adminRealm() {
		AdminRealm adminRealm = new AdminRealm();
		adminRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		adminRealm.setCacheManager(ehCacheManager());
		return adminRealm;
	}

	@Bean
	public StudentRealm studentRealm() {
		StudentRealm studentRealm = new StudentRealm();
		studentRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return studentRealm;
	}

	/**
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * 所以我们需要修改下doGetAuthenticationInfo中的代码; @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(3);// 散列的次数，比如散列两次，相当于md5(md5(""));
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);//表示是否存储散列后的密码为16进制，需要和生成密码时的一样，默认是base64；
		return hashedCredentialsMatcher;
	}

	/**
	 * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * shiro缓存管理器;
	 * 需要注入对应的其它的实体类中：
	 * 1、安全管理器：securityManager
	 * 可见securityManager是整个shiro的核心；
	 * https://blog.csdn.net/t15882918023/article/details/76726551
	 * @return
	 */
	@Bean
	public EhCacheManager ehCacheManager(){
		CacheManager cacheManager = CacheManager.getCacheManager("es");
		if(cacheManager == null){
			try {
				cacheManager = CacheManager.create(ResourceUtils.getInputStreamForPath("classpath:config/ehcache.xml"));
			} catch (IOException e) {
				throw new RuntimeException("initialize cacheManager failed");
			}
		}
		EhCacheManager ehCacheManager = new EhCacheManager();
		ehCacheManager.setCacheManager(cacheManager);
		return ehCacheManager;
	}
	
	@Bean
	public ShiroDialect getShiroDialect() {
		return new ShiroDialect();
	}
	

	@Bean
	public SimpleCookie getSimpleCookie() {
		SimpleCookie cookie = new SimpleCookie("rememberMe");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(2592000);
		return cookie;
	}

	/**
	 * cookie管理对象;
	 * @return
	 */
	@Bean
	public CookieRememberMeManager getCookieRememberManager(SimpleCookie simpleCookie) {
		CookieRememberMeManager manager = new CookieRememberMeManager();
		manager.setCookie(simpleCookie);
		return manager;
	}
}
