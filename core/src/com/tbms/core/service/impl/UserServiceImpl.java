package com.tbms.core.service.impl;

import java.util.*;

import javax.annotation.Resource;

import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.util.PasswordUtil;
import com.tbms.core.service.RoleService;
import org.springframework.stereotype.Service;

import com.tbms.core.dao.UserMapper;
import com.tbms.core.dto.UserDTO;
import com.tbms.core.service.UserService;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:40:38
 * 版本:       v1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userDAO;

	@Resource
	private  RoleService roleService;

	/**
	 * 根据ID获取
	 */
	public UserDTO getUserById(int id) {
		return userDAO.getUserById(id);
	}

	/**
	 * 根据username获取
	 */
	public UserDTO getUserByName(String username) {
		return userDAO.getUserByName(username);
	}

	/**
	 * 根据条件获取列表
	 */
	public List<UserDTO> getUserList(Map condition) {
		return userDAO.getUserList(condition);
	}

	/**
    * 根据条件获取分页列表
    */
    public PageResultSet<UserDTO> findByPage(Page page) {
		Map<Object, Object> condition = PageCondition.util(page);
        int count = userDAO.getUserListCount(condition);
        PageResultSet<UserDTO> resultSet = new PageResultSet<>();
        List<UserDTO> userPages = userDAO.getUserList(condition);
        resultSet.setRows(userPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取的列表总数
	 */
	public int getUserListCount(Map condition) {
		return userDAO.getUserListCount(condition);
	}

	/**
	 * 新增
	 */
	public int addUser(UserDTO userDTO) {
		String password = userDTO.getPassword();
		userDTO.setStatus(1);
		String pwd = PasswordUtil.hashPwd(password,userDTO.getCredentialsSalt());
		userDTO.setPassword(pwd);
		userDAO.addUser(userDTO);
		return userDTO.getId();
	}

	/**
	 * 更新
	 */
	public int updateUser(UserDTO userDTO) throws Exception {
		String password = userDTO.getPassword();
		if(password != null){
			String pwd = PasswordUtil.hashPwd(password,userDTO.getCredentialsSalt());
			userDTO.setPassword(pwd);
		}
		return userDAO.updateUser(userDTO);
	}

	/**
	 * 删除
	 */
	public int deleteUserById(int id) {
		return userDAO.deleteUserById(id);
	}

	/**
	 * 注销
	 */
	@Override
	public int unableUserById(int id) {
		return userDAO.unableUserById(id);
	}

	/**
	 * 查找用户的角色
	 */
	@Override
	public Set<String> findRoles(String username) {
		UserDTO user = this.getUserByName(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		//一个用户只对应一个角色
		return roleService.findRoles(Integer.parseInt(user.getRoleId()));
	}

	/**
	 * 查找用户可以访问的资源权限
	 */
	@Override
	public Set<String> findPermissions(String username) {
		UserDTO user = this.getUserByName(username);
		if(user == null){
			return Collections.EMPTY_SET;
		}
		//通过用户的角色id去查找
		return roleService.findPermissions(Integer.parseInt(user.getRoleId()));
	}
}
