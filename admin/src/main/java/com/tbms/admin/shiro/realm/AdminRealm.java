package com.tbms.admin.shiro.realm;

import com.tbms.core.common.kaptchar.CaptchaUsernamePasswordToken;
import com.tbms.core.common.util.WebUtil;
import com.tbms.core.dto.UserDTO;
import com.tbms.core.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;


@Component
public class AdminRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		UserDTO user = (UserDTO) principal.getPrimaryPrincipal();
		String username = user.getUsername();

		authorizationInfo.setRoles(userService.findRoles(username));
		authorizationInfo.setStringPermissions(userService.findPermissions(username));

		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		CaptchaUsernamePasswordToken info = (CaptchaUsernamePasswordToken) token;
		String username = (String)info.getPrincipal();
		if (StringUtils.isEmpty(username)) return null;
		UserDTO user = userService.getUserByName(username);
		if(user == null) {
			return null;
		}else{
			LoginLog(user);
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user,
				user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()),
				this.getName()
		);
		return authenticationInfo;
	}

	public void LoginLog(UserDTO user){
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setLoginCount(user.getLoginCount()+1);
		WebUtil wu = WebUtil.getInstance();
		String ip = wu.getIpAddress();// IP地址
		userDTO.setLastLoginIp(ip);
		userDTO.setStatus(user.getStatus());
		try {
			userService.updateUser(userDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
}
