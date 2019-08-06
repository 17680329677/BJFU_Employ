package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.MajorDTO;

/**
 * 类描述:     专业数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-02-02 15:13:48
 * 版本:       v1.0
 */
public interface MajorMapper {

	/**
	 * 根据ID查询专业
	 */
	MajorDTO getMajorById(int id);

	/**
	 * 根据条件查询专业列表
	 */
	List<MajorDTO> getMajorList(Map<Object, Object> condition);

	/**
	 * 查询专业的列表总数
	 */
	int getMajorListCount(Map<Object, Object> condition);

	/**
	 * 新增专业
	 */
	int addMajor(MajorDTO majorDTO);

	/**
	 * 更新专业
	 */
	int updateMajor(MajorDTO majorDTO);

	/**
	 * 删除专业
	 */
	int deleteMajorById(int id);


}
