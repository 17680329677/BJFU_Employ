package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.GraduationDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     就业统计业务接口
 * 创建人:     青枫
 * 创建时间:   2019-03-20 15:51:03
 * 版本:       v1.0
 */
public interface GraduationService {

	/**
	 * 根据ID获取就业统计
	 */
	GraduationDTO getGraduationById(int id);

	/**
	 * 根据条件获取就业统计列表
	 */
	List<GraduationDTO> getGraduationList(Map condition);

	/**
	 * 按专业统计结果插入数据库
	 */
	int insertMajorGraduation(Map<Object,Object> condition,Map<String,Integer> params) throws Exception;

	/**
	 * 按部门统计结果插入数据库
	 */
	int insertDepartGraduation(Map<Object,Object> condition,Map<String,Integer> params) throws Exception;

	/**
    * 根据条件分页查询获取就业统计列表
    */
    PageResultSet<GraduationDTO> findByPage(Page page);

	/**
	 * 获取就业统计的列表总数
	 */
	int getGraduationListCount(Map condition);

	/**
	 * 删除就业统计
	 */
	int deleteGraduationById(int id) throws Exception;

	/**
     * 批量删除就业统计
     */
    int deleteGraduationBatch(Integer[] ids) throws Exception;


}
