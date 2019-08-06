package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.BasicDTO;

/**
 * 类描述:     基础信息数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-02-02 15:13:48
 * 版本:       v1.0
 */
public interface BasicMapper {

	/**
	 * 根据ID查询基础信息
	 */
	BasicDTO getBasicById(int id);

	/**
	 * 根据type查询基础信息
	 */
	List<BasicDTO> getBasicByType(String type);

	/**
	 * 根据条件查询基础信息列表
	 */
	List<BasicDTO> getBasicList(Map<Object, Object> condition);

	/**
	 * 获取基础信息类型列表
	 */
	List<BasicDTO> getBasicTypeList();

	/**
	 * 查询基础信息的列表总数
	 */
	int getBasicListCount(Map<Object, Object> condition);

	/**
	 * 新增基础信息
	 */
	int addBasic(BasicDTO basicDTO);

	/**
	 * 更新基础信息
	 */
	int updateBasic(BasicDTO basicDTO);

	/**
	 * 删除基础信息
	 */
	int deleteBasicById(int id);


}
