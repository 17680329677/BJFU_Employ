package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.GraduationDTO;
import org.apache.ibatis.annotations.Param;

/**
 * 类描述:     就业统计数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-03-20 15:51:03
 * 版本:       v1.0
 */
public interface GraduationMapper {

	/**
	 * 根据ID查询就业统计
	 */
	GraduationDTO getGraduationById(int id);

	/**
	 * 根据条件查询就业统计列表
	 */
	List<GraduationDTO> getGraduationList(Map<Object, Object> condition);

	/**
	 * 按专业统计结果插入数据库
	 */
	int insertMajorGraduation(@Param("obj") Map<Object,Object> condition,@Param("params") Map<String,Integer> params);

	/**
	 * 按部门统计结果插入数据库
	 */
	int insertDepartGraduation(@Param("obj") Map<Object,Object> condition,@Param("params") Map<String,Integer> params);

	/**
	 * 查询就业统计的列表总数
	 */
	int getGraduationListCount(Map<Object, Object> condition);

	/**
	 * 删除就业统计
	 */
	int deleteGraduationById(int id);

	/**
     * 批量删除就业统计
     */
    int deleteGraduationBatch(Integer[] ids);


}
