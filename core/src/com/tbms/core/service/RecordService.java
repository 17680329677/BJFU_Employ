package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.RecordDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     档案信息业务接口
 * 创建人:     青枫
 * 创建时间:   2019-02-07 21:57:04
 * 版本:       v1.0
 */
public interface RecordService {

	/**
	 * 根据ID获取档案信息
	 */
	RecordDTO getRecordById(int id);

	/**
	 * 根据学号获取档案信息
	 */
	RecordDTO getRecordByAccount(String account);

	/**
	 * 根据条件获取档案信息列表
	 */
	List<RecordDTO> getRecordList(Map condition);

	/**
    * 根据条件分页查询获取档案信息列表
    */
    PageResultSet<RecordDTO> findByPage(Page page);

	/**
	 * 获取档案信息的列表总数
	 */
	int getRecordListCount(Map condition);

	/**
	 * 新增档案信息
	 */
	int addRecord(RecordDTO recordDTO);

	/**
	 * 更新档案信息
	 */
	int updateRecord(RecordDTO recordDTO) throws Exception;

	/**
	 * 删除档案信息
	 */
	int deleteRecordById(int id);


}
