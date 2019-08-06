package com.tbms.admin.shiro.realm;

import com.tbms.core.common.kaptchar.CaptchaUsernamePasswordToken;
import com.tbms.core.common.util.WebUtil;
import com.tbms.core.dto.StudentDTO;
import com.tbms.core.service.StudentService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class StudentRealm extends AuthorizingRealm {

	@Autowired
	private StudentService studentService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		CaptchaUsernamePasswordToken info = (CaptchaUsernamePasswordToken) token;
		String username = info.getUsername();
		if (StringUtils.isEmpty(username)) return null;
		StudentDTO student = studentService.getStudentByName(username);
		if(student != null) {
			LoginLog(student);
			return new SimpleAuthenticationInfo(
					student,
					student.getPassword(),
					ByteSource.Util.bytes(student.getCredentialsSalt()),
					this.getName());
		}
		return null;
	}

	public void LoginLog(StudentDTO student){
		StudentDTO user = new StudentDTO();
		user.setId(student.getId());
		user.setLoginCount(student.getLoginCount()+1);
		WebUtil wu = WebUtil.getInstance();
		String ip = wu.getIpAddress();// IP地址
		user.setLastLoginIp(ip);
		user.setStatus(student.getStatus());
		try {
			studentService.updateStudent(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
