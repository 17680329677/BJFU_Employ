package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.RecordDTO;

/**
 * 类描述:     档案信息数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-02-08 10:14:37
 * 版本:       v1.0
 */
public interface RecordMapper {

	/**
	 * 根据ID查询档案信息
	 */
	RecordDTO getRecordById(int id);

	/**
	 * 根据学号查询档案信息
	 */
	RecordDTO getRecordByAccount(String account);

	/**
	 * 根据条件查询档案信息列表
	 */
	List<RecordDTO> getRecordList(Map<Object, Object> condition);

	/**
	 * 查询档案信息的列表总数
	 */
	int getRecordListCount(Map<Object, Object> condition);

	/**
	 * 新增档案信息
	 */
	int addRecord(RecordDTO recordDTO);

	/**
	 * 更新档案信息
	 */
	int updateRecord(RecordDTO recordDTO);

	/**
	 * 删除档案信息
	 */
	int deleteRecordById(int id);


}
