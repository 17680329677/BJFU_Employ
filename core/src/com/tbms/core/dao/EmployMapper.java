package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.EmployDTO;

/**
 * 类描述:     就业信息数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-02-08 10:14:37
 * 版本:       v1.0
 */
public interface EmployMapper {

	/**
	 * 根据ID查询就业信息
	 */
	EmployDTO getEmployById(int id);

	/**
	 * 根据学号查就业信息
	 */
	EmployDTO getEmployByAccount(String account);

	/**
	 * 根据条件查询就业信息列表
	 */
	List<EmployDTO> getEmployList(Map<Object, Object> condition);

	/**
	 * 查询就业信息的列表总数
	 */
	int getEmployListCount(Map<Object, Object> condition);

	/**
	 * 新增就业信息
	 */
	int addEmploy(EmployDTO employDTO);

	/**
	 * 更新就业信息
	 */
	int updateEmploy(EmployDTO employDTO);

	/**
	 * 删除就业信息
	 */
	int deleteEmployById(int id);


}
