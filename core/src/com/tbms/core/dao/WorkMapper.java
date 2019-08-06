package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.WorkDTO;

/**
 * 类描述:     学生全部信息数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-03-06 14:51:39
 * 版本:       v1.0
 */
public interface WorkMapper {

	/**
	 * 根据条件查询学生全部信息列表
	 */
	List<WorkDTO> getWorkList(Map<Object, Object> condition);

	/**
	 * 查询学生全部信息的列表总数
	 */
	int getWorkListCount(Map<Object, Object> condition);

}
