package com.tbms.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tbms.core.dao.WorkMapper;
import com.tbms.core.dto.WorkDTO;
import com.tbms.core.service.WorkService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     学生全部信息业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-03-06 14:51:39
 * 版本:       v1.0
 */
@Service("workService")
public class WorkServiceImpl implements WorkService {


	@Resource
	private WorkMapper workDAO;

	/**
	 * 根据条件获取学生全部信息列表
	 */
	public List<WorkDTO> getWorkList(Map condition) {
		return workDAO.getWorkList(condition);
	}

	/**
    * 根据条件获取分页学生全部信息列表
    */
    public PageResultSet<WorkDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = workDAO.getWorkListCount(condition);
        PageResultSet<WorkDTO> resultSet = new PageResultSet<>();
        List<WorkDTO> workPages = workDAO.getWorkList(condition);
        resultSet.setRows(workPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 学生个人就业信息查看
	 */
	public PageResultSet<WorkDTO> findByPage(Page page,String account) {
		Map<Object, Object> condition = PageCondition.util(page,account);
		int count = workDAO.getWorkListCount(condition);
		PageResultSet<WorkDTO> resultSet = new PageResultSet<>();
		List<WorkDTO> workPages = workDAO.getWorkList(condition);
		resultSet.setRows(workPages);
		resultSet.setTotal(count);
		return resultSet;
	}

	/**
	 * 获取学生全部信息的列表总数
	 */
	public int getWorkListCount(Map condition) {
		return workDAO.getWorkListCount(condition);
	}

}
