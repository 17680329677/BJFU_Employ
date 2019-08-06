package com.tbms.core.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tbms.core.dto.RoleResourceDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     角色资源业务接口
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:40:38
 * 版本:       v1.0
 */
public interface RoleResourceService {

	/**
	 * 根据ID获取
	 */
	RoleResourceDTO getRoleResourceById(int id);

	/**
	 * 根据条件获取列表
	 */
	List<RoleResourceDTO> getRoleResourceList(Map condition);

	/**
    * 根据条件分页查询获取列表
    */
    PageResultSet<RoleResourceDTO> findByPage(Page page);

	/**
	 * 获取的列表总数
	 */
	int getRoleResourceListCount(Map condition);

	/**
	 * 新增
	 */
	int addRoleResource(RoleResourceDTO roleResourceDTO);

	/**
	 * 更新
	 */
	int updateRoleResource(RoleResourceDTO roleResourceDTO) throws Exception;

	/**
	 * 删除
	 */
	int deleteRoleResourceById(int id);

	/**
	 * 获取资源列表的ID
	 * @param id
	 * @return List
	 */
	List<Integer> getResourceIdList(int id);

	/**
	 *获取资源列表的名称
	 * @param id
	 * @return
	 */
	List<String> getResourceNames(int id);

	Set<String> findPermissions(Set<Integer> resourceIds);


}
