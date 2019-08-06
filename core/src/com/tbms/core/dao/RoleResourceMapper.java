package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.RoleResourceDTO;

/**
 * 类描述:     角色资源数据处理接口
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:34:49
 * 版本:       v1.0
 */
public interface RoleResourceMapper {

	/**
	 * 根据ID查询
	 */
	RoleResourceDTO getRoleResourceById(int id);

	/**
	 * 根据条件查询列表
	 */
	List<RoleResourceDTO> getRoleResourceList(Map<Object, Object> condition);

	/**
    * 根据条件查询列表
    */
    List<RoleResourceDTO> getRoleResourcePage(Map<Object, Object> condition);

	/**
	 * 查询的列表总数
	 */
	int getRoleResourceListCount(Map<Object, Object> condition);

	/**
	 * 新增
	 */
	int addRoleResource(RoleResourceDTO roleResourceDTO);

	/**
	 * 更新
	 */
	int updateRoleResource(RoleResourceDTO roleResourceDTO);

	/**
	 * 删除
	 */
	int deleteRoleResourceById(int id);


}
