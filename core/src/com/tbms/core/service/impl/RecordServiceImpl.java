package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tbms.core.dao.RecordMapper;
import com.tbms.core.dto.RecordDTO;
import com.tbms.core.service.RecordService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     档案信息业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-02-07 21:57:04
 * 版本:       v1.0
 */
@Service("recordService")
public class RecordServiceImpl implements RecordService {


	@Resource
	private RecordMapper recordDAO;

	/**
	 * 根据ID获取档案信息
	 */
	public RecordDTO getRecordById(int id) {
		return recordDAO.getRecordById(id);
	}

	/**
	 * 根据ID获取档案信息
	 */
	public RecordDTO getRecordByAccount(String account) {
		return recordDAO.getRecordByAccount(account);
	}

	/**
	 * 根据条件获取档案信息列表
	 */
	public List<RecordDTO> getRecordList(Map condition) {
		return recordDAO.getRecordList(condition);
	}

	/**
    * 根据条件获取分页档案信息列表
    */
    public PageResultSet<RecordDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = recordDAO.getRecordListCount(condition);
        PageResultSet<RecordDTO> resultSet = new PageResultSet<>();
        List<RecordDTO> recordPages = recordDAO.getRecordList(condition);
        resultSet.setRows(recordPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取档案信息的列表总数
	 */
	public int getRecordListCount(Map condition) {
		return recordDAO.getRecordListCount(condition);
	}

	/**
	 * 新增档案信息
	 */
	public int addRecord(RecordDTO recordDTO) {
		recordDAO.addRecord(recordDTO);
		return recordDTO.getId();
	}

	/**
	 * 更新档案信息
	 */
	public int updateRecord(RecordDTO recordDTO) throws Exception {
		return recordDAO.updateRecord(recordDTO);
	}

	/**
	 * 删除档案信息
	 */
	public int deleteRecordById(int id) {
		return recordDAO.deleteRecordById(id);
	}


}
