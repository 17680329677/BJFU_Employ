package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.LogDTO;

/**
 * 类描述:     日志数据处理接口
 * 创建人:     青枫
 * 创建时间:   2018-08-05 08:58:06
 * 版本:       v1.0
 */
public interface LogMapper {

	/**
	 * 根据ID查询
	 */
	LogDTO getLogById(int id);

	/**
	 * 根据条件查询列表
	 */
	List<LogDTO> getLogList(Map<Object, Object> condition);

	/**
	 * 根据条件查询列表
	 */
	List<LogDTO> getLogPage(Map<Object, Object> condition);

	/**
	 * 查询的列表总数
	 */
	int getLogListCount(Map<Object, Object> condition);

	/**
	 * 新增
	 */
	int addLog(LogDTO logDTO);

	/**
	 * 更新
	 */
	int updateLog(LogDTO logDTO);

	/**
	 * 删除
	 */
	int deleteLogById(int id);


}
