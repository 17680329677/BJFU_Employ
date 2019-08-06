package com.tbms.core.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tbms.core.dto.UserDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:40:38
 * 版本:       v1.0
 */
public interface UserService {

	/**
	 * 根据ID获取
	 */
	UserDTO getUserById(int id);

	/**
	 * 根据ID获取
	 */
	UserDTO getUserByName(String username);

	/**
	 * 根据条件获取列表
	 */
	List<UserDTO> getUserList(Map condition);

	/**
    * 根据条件分页查询获取列表
    */
    PageResultSet<UserDTO> findByPage(Page page);

	/**
	 * 获取的列表总数
	 */
	int getUserListCount(Map condition);

	/**
	 * 新增
	 */
	int addUser(UserDTO userDTO);

	/**
	 * 更新
	 */
	int updateUser(UserDTO userDTO) throws Exception;

	/**
	 * 删除
	 */
	int deleteUserById(int id);

	/**
	 * 注销
	 */
	int unableUserById(int id);

	/**
	 * 根据用户名查找其角色
	 * @param username
	 * @return
	 */
	Set<String> findRoles(String username);

	/**
	 * 根据用户名查找其权限
	 * @param username
	 * @return
	 */
	Set<String> findPermissions(String username);


}
