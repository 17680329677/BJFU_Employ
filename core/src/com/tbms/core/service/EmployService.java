package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.EmployDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     就业信息业务接口
 * 创建人:     青枫
 * 创建时间:   2019-02-07 21:57:03
 * 版本:       v1.0
 */
public interface EmployService {

	/**
	 * 根据ID获取就业信息
	 */
	EmployDTO getEmployById(int id);

	/**
	 * 根据学号获取就业信息
	 */
	EmployDTO getEmployByAccount(String account);

	/**
	 * 根据条件获取就业信息列表
	 */
	List<EmployDTO> getEmployList(Map condition);

	/**
    * 根据条件分页查询获取就业信息列表
    */
    PageResultSet<EmployDTO> findByPage(Page page);

	/**
	 * 获取就业信息的列表总数
	 */
	int getEmployListCount(Map condition);

	/**
	 * 新增就业信息
	 */
	int addEmploy(EmployDTO employDTO);

	/**
	 * 更新就业信息
	 */
	int updateEmploy(EmployDTO employDTO) throws Exception;

	/**
	 * 删除就业信息
	 */
	int deleteEmployById(int id);


}
