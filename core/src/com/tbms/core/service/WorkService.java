package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.WorkDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     学生全部信息业务接口
 * 创建人:     青枫
 * 创建时间:   2019-03-06 14:51:39
 * 版本:       v1.0
 */
public interface WorkService {

	/**
	 * 根据条件获取学生全部信息列表
	 */
	List<WorkDTO> getWorkList(Map condition);

	/**
    * 根据条件分页查询获取学生全部信息列表
    */
    PageResultSet<WorkDTO> findByPage(Page page);

	/**
	 * 根据条件分页查询获取学生全部信息列表
	 */
	PageResultSet<WorkDTO> findByPage(Page page,String account);

	/**
	 * 获取学生全部信息的列表总数
	 */
	int getWorkListCount(Map condition);

}
