package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbms.core.dao.AnalyseMapper;
import com.tbms.core.dto.AnalyseDTO;
import com.tbms.core.service.AnalyseService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     就业统计业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-03-09 11:37:04
 * 版本:       v1.0
 */
@Service("analyseService")
public class AnalyseServiceImpl implements AnalyseService {


	@Resource
	private AnalyseMapper analyseDAO;

	/**
	 * 根据ID获取就业统计
	 */
	public AnalyseDTO getAnalyseById(int id) {
		return analyseDAO.getAnalyseById(id);
	}

	/**
	 * 根据条件获取就业统计列表
	 */
	public List<AnalyseDTO> getAnalyseList(Map condition) {
		return analyseDAO.getAnalyseList(condition);
	}

	/**
	 * 按专业统计结果插入数据库
	 */
	@Override
	public int insertMajorWeekAnalyse(Map<Object,Object> condition,Map<String,Integer> params) throws Exception{
		return analyseDAO.insertMajorWeekAnalyse(condition,params);
	}

	/**
	 * 按部门统计结果插入数据库
	 */
	@Override
	public int insertDepartWeekAnalyse(Map<Object,Object> condition,Map<String,Integer> params) throws Exception{
		return analyseDAO.insertDepartWeekAnalyse(condition,params);
	}

	/**
	 * 根据条件查询每周就业统计列表
	 */
	public List<AnalyseDTO> getWeekAnalyseList(Map<Object,Object> condition,Map<String,Integer> params){
		return analyseDAO.getWeekAnalyseList(condition,params);
	}

	/**
	 * 根据条件查询每周就业学院统计列表
	 */
	@Override
	public List<AnalyseDTO> getWeekDepartAnalyseList(Map<Object,Object> condition,Map<String,Integer> params) {
		return analyseDAO.getWeekDepartAnalyseList(condition,params);
	}

	/**
	 * 根据条件获取分页就业统计列表
	 */
	public PageResultSet<AnalyseDTO> findByPage(Page page) {
		Map<Object, Object> condition = PageCondition.util(page);
		int count = analyseDAO.getAnalyseListCount(condition);
		PageResultSet<AnalyseDTO> resultSet = new PageResultSet<>();
		List<AnalyseDTO> analysePages = analyseDAO.getAnalyseList(condition);
		resultSet.setRows(analysePages);
		resultSet.setTotal(count);
		return resultSet;
	}

	/**
	 * 获取就业统计的列表总数
	 */
	public int getAnalyseListCount(Map condition) {
		return analyseDAO.getAnalyseListCount(condition);
	}

	/**
	 * 新增就业统计
	 */
	public int addAnalyse(AnalyseDTO analyseDTO) {
		analyseDAO.addAnalyse(analyseDTO);
		return analyseDTO.getId();
	}

	/**
	 * 批量新增就业统计
	 */
	@Transactional
	public int addAnalyseBatch(List<AnalyseDTO> list) throws Exception{
		return analyseDAO.addAnalyseBatch(list);
	}

	/**
	 * 更新就业统计
	 */
	public int updateAnalyse(AnalyseDTO analyseDTO) throws Exception {
		return analyseDAO.updateAnalyse(analyseDTO);
	}

	/**
	 * 批量更新就业统计
	 */
	@Override
	@Transactional
	public int updateAnalyseBatch(Integer[] ids,AnalyseDTO analyseDTO) throws Exception{
		return analyseDAO.updateAnalyseBatch(ids,analyseDTO);
	}

	/**
	 * 删除就业统计
	 */
	public int deleteAnalyseById(int id) {
		return analyseDAO.deleteAnalyseById(id);
	}

	/**
	 *批量删除就业统计
	 */
	@Transactional
	public int deleteAnalyseBatch(Integer[] ids)throws Exception{
		return analyseDAO.deleteAnalyseBatch(ids);
	}

}
