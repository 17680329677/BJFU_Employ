package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.LogDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口
 * 创建人:     青枫
 * 创建时间:   2018-08-05 08:58:06
 * 版本:       v1.0
 */
public interface LogService {

	/**
	 * 根据ID获取
	 */
	LogDTO getLogById(int id);

	/**
	 * 根据条件获取列表
	 */
	List<LogDTO> getLogList(Map condition);

	/**
    * 根据条件分页查询获取列表
    */
    PageResultSet<LogDTO> findByPage(Page page);

	/**
	 * 获取的列表总数
	 */
	int getLogListCount(Map condition);

	/**
	 * 新增
	 */
	long addLog(LogDTO logDTO);

	/**
	 * 更新
	 */
	int updateLog(LogDTO logDTO) throws Exception;

	/**
	 * 删除
	 */
	int deleteLogById(int id);


}
