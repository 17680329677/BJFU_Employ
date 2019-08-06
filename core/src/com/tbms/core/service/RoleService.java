package com.tbms.core.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tbms.core.dto.RoleDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     角色业务接口
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:40:38
 * 版本:       v1.0
 */
public interface RoleService {

	/**
	 * 根据ID获取
	 */
	RoleDTO getRoleById(int id);

	/**
	 * 根据条件获取列表
	 */
	List<RoleDTO> getRoleList(Map condition);

	/**
    * 根据条件分页查询获取列表
    */
    PageResultSet<RoleDTO> findByPage(Page page);

	/**
	 * 获取的列表总数
	 */
	int getRoleListCount(Map condition);

	/**
	 * 新增
	 */
	int addRole(RoleDTO roleDTO);

	/**
	 * 更新
	 */
	int updateRole(RoleDTO roleDTO) throws Exception;

	/**
	 * 删除
	 */
	int deleteRoleById(int id);

	Set<String> findRoles(Integer roleId);

	Set<String> findPermissions(Integer roleId);

}
