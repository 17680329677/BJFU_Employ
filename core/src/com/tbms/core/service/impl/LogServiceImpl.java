package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.tbms.core.common.base.PageCondition;
import org.springframework.stereotype.Service;

import com.tbms.core.dao.LogMapper;
import com.tbms.core.dto.LogDTO;
import com.tbms.core.service.LogService;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     日志业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2018-08-05 08:58:06
 * 版本:       v1.0
 */
@Service("logService")
public class LogServiceImpl implements LogService {


	@Resource
	private LogMapper logDAO;

	/**
	 * 根据ID获取
	 */
	public LogDTO getLogById(int id) {
		return logDAO.getLogById(id);
	}

	/**
	 * 根据条件获取列表
	 */
	public List<LogDTO> getLogList(Map condition) {
		return logDAO.getLogList(condition);
	}

	/**
    * 根据条件获取分页列表
    */
    public PageResultSet<LogDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = logDAO.getLogListCount(condition);
        PageResultSet<LogDTO> resultSet = new PageResultSet<>();
        List<LogDTO> logPages = logDAO.getLogPage(condition);
        resultSet.setRows(logPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取的列表总数
	 */
	public int getLogListCount(Map condition) {
		return logDAO.getLogListCount(condition);
	}

	/**
	 * 新增
	 */
	public long addLog(LogDTO logDTO) {
		logDAO.addLog(logDTO);
		return logDTO.getId();
	}

	/**
	 * 更新
	 */
	public int updateLog(LogDTO logDTO) throws Exception {
		return logDAO.updateLog(logDTO);
	}

	/**
	 * 删除
	 */
	public int deleteLogById(int id) {
		return logDAO.deleteLogById(id);
	}


}
