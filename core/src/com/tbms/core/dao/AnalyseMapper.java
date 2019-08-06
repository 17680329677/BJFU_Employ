package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.AnalyseDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 类描述:     就业统计数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-03-09 11:37:04
 * 版本:       v1.0
 */
public interface AnalyseMapper {

	/**
	 * 根据ID查询就业统计
	 */
	AnalyseDTO getAnalyseById(int id);

	/**
	 * 根据条件查询就业统计列表
	 */
	List<AnalyseDTO> getAnalyseList(Map<Object,Object> condition);

	/**
	 * 根据条件查询专业就业统计列表
	 */
	List<AnalyseDTO> getWeekAnalyseList(@Param("obj") Map<Object,Object> condition,@Param("params") Map<String,Integer> params);

	/**
	 * 根据条件查询学院就业统计列表
	 */
	List<AnalyseDTO> getWeekDepartAnalyseList(@Param("obj") Map<Object,Object> condition,@Param("params") Map<String,Integer> params);

	/**
	 * 查询就业统计的列表总数
	 */
	int getAnalyseListCount(Map<Object,Object> condition);

	/**
	 * 新增就业统计
	 */
	int addAnalyse(AnalyseDTO analyseDTO);

	/**
	 * 批量新增就业统计
	 */
	int addAnalyseBatch(List<AnalyseDTO> list);

	/**
	 * 按专业统计结果插入数据库
	 */
	int insertMajorWeekAnalyse(@Param("obj") Map<Object,Object> condition,@Param("params") Map<String,Integer> params);

	/**
	 * 按部门统计结果插入数据库
	 */
	int insertDepartWeekAnalyse(@Param("obj") Map<Object,Object> condition,@Param("params") Map<String,Integer> params);

	/**
	 * 更新就业统计
	 */
	int updateAnalyse(AnalyseDTO analyseDTO);

	/**
	 * 批量更新就业统计
	 */
	int updateAnalyseBatch(@Param("ids") Integer[] ids, @Param("analyse") AnalyseDTO analyse);

	/**
	 * 删除就业统计
	 */
	int deleteAnalyseById(int id);

	/**
	 * 批量删除就业统计
	 */
	int deleteAnalyseBatch(Integer[] ids);


}
