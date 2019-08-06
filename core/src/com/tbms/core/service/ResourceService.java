package com.tbms.core.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tbms.core.dto.ResourceDTO;

/**
 * 类描述:     业务接口
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:40:38
 * 版本:       v1.0
 */
public interface ResourceService {

	/**
	 * 根据ID获取
	 */
	ResourceDTO getResourceById(int id);

	/**
	 * 根据条件获取列表
	 */
	List<ResourceDTO> getResourceList(Map condition);

	/**
	 * 获取的列表总数
	 */
	int getResourceListCount(Map condition);

	/**
	 * 新增
	 */
	int addResource(ResourceDTO resourceDTO);

	/**
	 * 更新
	 */
	int updateResource(ResourceDTO resourceDTO) throws Exception;

	/**
	 * 删除
	 */
	int deleteResourceById(int id);

	/**
	 * 得到资源对应的权限字符串
	 * @param resourceIds
	 * @return
	 */
	Set<String> findPermissions(Set<Integer> resourceIds);

	/**
	 * 根据用户权限得到菜单
	 * @param permissions
	 * @return
	 */
	List<ResourceDTO> findMenus(Set<String> permissions);


}
