package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.ResourceDTO;

/**
 * 类描述:     资源数据处理接口
 * 创建人:     青枫
 * 创建时间:   2018-06-11 22:34:48
 * 版本:       v1.0
 */
public interface ResourceMapper {

	/**
	 * 根据ID查询
	 */
	ResourceDTO getResourceById(int id);

	/**
	 * 根据条件查询列表
	 */
	List<ResourceDTO> getResourceList(Map<Object, Object> condition);

	/**
	 * 查询的列表总数
	 */
	int getResourceListCount(Map<Object, Object> condition);

	/**
	 * 新增
	 */
	int addResource(ResourceDTO resourceDTO);

	/**
	 * 更新
	 */
	int updateResource(ResourceDTO resourceDTO);

	/**
	 * 删除
	 */
	int deleteResourceById(int id);


}
