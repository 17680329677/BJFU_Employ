package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tbms.core.dao.EmployMapper;
import com.tbms.core.dto.EmployDTO;
import com.tbms.core.service.EmployService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     就业信息业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-02-07 21:57:03
 * 版本:       v1.0
 */
@Service("employService")
public class EmployServiceImpl implements EmployService {


	@Resource
	private EmployMapper employDAO;

	/**
	 * 根据ID获取就业信息
	 */
	public EmployDTO getEmployById(int id) {
		return employDAO.getEmployById(id);
	}

	/**
	 * 根据学号获取就业信息
	 */
	public EmployDTO getEmployByAccount (String account) {
		return employDAO.getEmployByAccount(account);
	}

	/**
	 * 根据条件获取就业信息列表
	 */
	public List<EmployDTO> getEmployList(Map condition) {
		return employDAO.getEmployList(condition);
	}

	/**
    * 根据条件获取分页就业信息列表
    */
    public PageResultSet<EmployDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = employDAO.getEmployListCount(condition);
        PageResultSet<EmployDTO> resultSet = new PageResultSet<>();
        List<EmployDTO> employPages = employDAO.getEmployList(condition);
        resultSet.setRows(employPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取就业信息的列表总数
	 */
	public int getEmployListCount(Map condition) {
		return employDAO.getEmployListCount(condition);
	}

	/**
	 * 新增就业信息
	 */
	public int addEmploy(EmployDTO employDTO) {
		employDAO.addEmploy(employDTO);
		return employDTO.getId();
	}

	/**
	 * 更新就业信息
	 */
	public int updateEmploy(EmployDTO employDTO) throws Exception {
		return employDAO.updateEmploy(employDTO);
	}

	/**
	 * 删除就业信息
	 */
	public int deleteEmployById(int id) {
		return employDAO.deleteEmployById(id);
	}


}
