package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbms.core.dao.GraduationMapper;
import com.tbms.core.dto.GraduationDTO;
import com.tbms.core.service.GraduationService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     就业统计业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-03-20 15:51:03
 * 版本:       v1.0
 */
@Service("graduationService")
public class GraduationServiceImpl implements GraduationService {


	@Resource
	private GraduationMapper graduationDAO;

	/**
	 * 根据ID获取就业统计
	 */
	public GraduationDTO getGraduationById(int id) {
		return graduationDAO.getGraduationById(id);
	}

	/**
	 * 根据条件获取就业统计列表
	 */
	public List<GraduationDTO> getGraduationList(Map condition) {
		return graduationDAO.getGraduationList(condition);
	}

	/**
	 * 按专业统计结果插入数据库
	 */
	@Override
	public int insertMajorGraduation(Map<Object,Object> condition,Map<String,Integer> params) throws Exception{
		return graduationDAO.insertMajorGraduation(condition,params);
	}
	/**
	 * 按部门统计结果插入数据库
	 */
	@Override
	public int insertDepartGraduation(Map<Object,Object> condition,Map<String,Integer> params) throws Exception{
		return graduationDAO.insertDepartGraduation(condition,params);
	}

	/**
    * 根据条件获取分页就业统计列表
    */
    public PageResultSet<GraduationDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = graduationDAO.getGraduationListCount(condition);
        PageResultSet<GraduationDTO> resultSet = new PageResultSet<>();
        List<GraduationDTO> graduationPages = graduationDAO.getGraduationList(condition);
        resultSet.setRows(graduationPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取就业统计的列表总数
	 */
	public int getGraduationListCount(Map condition) {
		return graduationDAO.getGraduationListCount(condition);
	}

	/**
	 * 删除就业统计
	 */
	public int deleteGraduationById(int id) {
		return graduationDAO.deleteGraduationById(id);
	}

	/**
	 *批量删除就业统计
	 */
	@Transactional
	public int deleteGraduationBatch(Integer[] ids)throws Exception{
		return graduationDAO.deleteGraduationBatch(ids);
	}


}
