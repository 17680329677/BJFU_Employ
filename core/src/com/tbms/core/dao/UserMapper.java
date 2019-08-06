package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.UserDTO;

/**
 * 类描述:     数据处理接口
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:34:49
 * 版本:       v1.0
 */
public interface UserMapper {

	/**
	 * 根据ID查询
	 */
	UserDTO getUserById(int id);

	/**
	 * 根据username查询
	 */
	UserDTO getUserByName(String username);

	/**
	 * 根据条件查询列表
	 */
	List<UserDTO> getUserList(Map<Object, Object> condition);

	/**
	 * 查询的列表总数
	 */
	int getUserListCount(Map<Object, Object> condition);

	/**
	 * 新增
	 */
	int addUser(UserDTO userDTO);

	/**
	 * 更新
	 */
	int updateUser(UserDTO userDTO);

	/**
	 * 删除
	 */
	int deleteUserById(int id);

	/**
	 * 注销
	 */
	int unableUserById(int id);


}
