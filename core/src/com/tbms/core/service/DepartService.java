package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.DepartDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     部门管理业务接口
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:43:22
 * 版本:       v1.0
 */
public interface DepartService {

	/**
	 * 根据ID获取部门管理
	 */
	DepartDTO getDepartById(int id);

	/**
	 * 根据条件获取部门管理列表
	 */
	List<DepartDTO> getDepartList(Map condition);

	/**
    * 根据条件分页查询获取部门管理列表
    */
    PageResultSet<DepartDTO> findByPage(Page page);

	/**
	 * 获取部门管理的列表总数
	 */
	int getDepartListCount(Map condition);

	/**
	 * 新增部门管理
	 */
	int addDepart(DepartDTO departDTO);

	/**
	 * 更新部门管理
	 */
	int updateDepart(DepartDTO departDTO) throws Exception;

	/**
	 * 删除部门管理
	 */
	int deleteDepartById(int id);


}
