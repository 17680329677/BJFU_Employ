package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.RoleDTO;

/**
 * 类描述:     角色数据处理接口
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:34:49
 * 版本:       v1.0
 */
public interface RoleMapper {

	/**
	 * 根据ID查询
	 */
	RoleDTO getRoleById(int id);

	/**
	 * 根据条件查询列表
	 */
	List<RoleDTO> getRoleList(Map<Object, Object> condition);

	/**
    * 根据条件查询列表
    */
    List<RoleDTO> getRolePage(Map<Object, Object> condition);

	/**
	 * 查询的列表总数
	 */
	int getRoleListCount(Map<Object, Object> condition);

	/**
	 * 新增
	 */
	int addRole(RoleDTO roleDTO);

	/**
	 * 更新
	 */
	int updateRole(RoleDTO roleDTO);

	/**
	 * 删除
	 */
	int deleteRoleById(int id);


}
