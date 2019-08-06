package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.DepartDTO;

/**
 * 类描述:     部门管理数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-02-02 15:13:48
 * 版本:       v1.0
 */
public interface DepartMapper {

	/**
	 * 根据ID查询部门管理
	 */
	DepartDTO getDepartById(int id);

	/**
	 * 根据条件查询部门管理列表
	 */
	List<DepartDTO> getDepartList(Map<Object, Object> condition);

	/**
	 * 查询部门管理的列表总数
	 */
	int getDepartListCount(Map<Object, Object> condition);

	/**
	 * 新增部门管理
	 */
	int addDepart(DepartDTO departDTO);

	/**
	 * 更新部门管理
	 */
	int updateDepart(DepartDTO departDTO);

	/**
	 * 删除部门管理
	 */
	int deleteDepartById(int id);


}
