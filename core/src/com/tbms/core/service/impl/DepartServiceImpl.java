package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.tbms.core.common.base.PageCondition;
import org.springframework.stereotype.Service;

import com.tbms.core.dao.DepartMapper;
import com.tbms.core.dto.DepartDTO;
import com.tbms.core.service.DepartService;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     部门管理业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:43:22
 * 版本:       v1.0
 */
@Service("departService")
public class DepartServiceImpl implements DepartService {


	@Resource
	private DepartMapper departDAO;

	/**
	 * 根据ID获取部门管理
	 */
	public DepartDTO getDepartById(int id) {
		return departDAO.getDepartById(id);
	}

	/**
	 * 根据条件获取部门管理列表
	 */
	public List<DepartDTO> getDepartList(Map condition) {
		return departDAO.getDepartList(condition);
	}

	/**
    * 根据条件获取分页部门管理列表
    */
    public PageResultSet<DepartDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = departDAO.getDepartListCount(condition);
        PageResultSet<DepartDTO> resultSet = new PageResultSet<>();
        List<DepartDTO> departPages = departDAO.getDepartList(condition);
        resultSet.setRows(departPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取部门管理的列表总数
	 */
	public int getDepartListCount(Map condition) {
		return departDAO.getDepartListCount(condition);
	}

	/**
	 * 新增部门管理
	 */
	public int addDepart(DepartDTO departDTO) {
		departDAO.addDepart(departDTO);
		return departDTO.getId();
	}

	/**
	 * 更新部门管理
	 */
	public int updateDepart(DepartDTO departDTO) throws Exception {
		return departDAO.updateDepart(departDTO);
	}

	/**
	 * 删除部门管理
	 */
	public int deleteDepartById(int id) {
		return departDAO.deleteDepartById(id);
	}


}
