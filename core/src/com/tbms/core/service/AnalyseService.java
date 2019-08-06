package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.AnalyseDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     就业统计业务接口
 * 创建人:     青枫
 * 创建时间:   2019-03-09 11:37:04
 * 版本:       v1.0
 */
public interface AnalyseService {

	/**
	 * 根据ID获取就业统计
	 */
	AnalyseDTO getAnalyseById(int id);

	/**
	 * 根据条件获取就业统计列表
	 */
	List<AnalyseDTO> getAnalyseList(Map condition);

	/**
	 * 按专业统计结果插入数据库
	 */
	int insertMajorWeekAnalyse(Map<Object,Object> condition,Map<String,Integer> params) throws Exception;

	/**
	 * 按部门统计结果插入数据库
	 */
	int insertDepartWeekAnalyse(Map<Object,Object> condition,Map<String,Integer> params) throws Exception;

	/**
	 * 根据条件查询每周就业统计列表
	 */
	List<AnalyseDTO> getWeekAnalyseList(Map<Object,Object> condition,Map<String,Integer> params);

	/**
	 * 根据条件查询每周就业学院统计列表
	 */
	List<AnalyseDTO> getWeekDepartAnalyseList(Map<Object,Object> condition,Map<String,Integer> params);

	/**
	 * 根据条件分页查询获取就业统计列表
	 */
	PageResultSet<AnalyseDTO> findByPage(Page page);

	/**
	 * 获取就业统计的列表总数
	 */
	int getAnalyseListCount(Map condition);

	/**
	 * 新增就业统计
	 */
	int addAnalyse(AnalyseDTO analyseDTO) throws Exception;

	/**
	 * 批量添加就业统计
	 */
	int addAnalyseBatch(List<AnalyseDTO> list) throws Exception;

	/**
	 * 更新就业统计
	 */
	int updateAnalyse(AnalyseDTO analyseDTO) throws Exception;

	/**
	 * 批量更新就业统计
	 */
	int updateAnalyseBatch(Integer[] ids,AnalyseDTO analyseDTO) throws Exception;

	/**
	 * 删除就业统计
	 */
	int deleteAnalyseById(int id) throws Exception;

	/**
	 * 批量删除就业统计
	 */
	int deleteAnalyseBatch(Integer[] ids) throws Exception;

}
