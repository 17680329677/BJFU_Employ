package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.BasicDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     基础信息业务接口
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:42:58
 * 版本:       v1.0
 */
public interface BasicService {

	/**
	 * 根据ID获取基础信息
	 */
	BasicDTO getBasicById(int id);

	/**
	 * 根据type获取基础信息
	 */
	List<BasicDTO> getBasicByType(String type);

	/**
	 * 根据条件获取基础信息列表
	 */
	List<BasicDTO> getBasicList(Map condition);

	/**
	 * 获取基础信息类型列表
	 */
	List<BasicDTO> getBasicTypeList();

	/**
    * 根据条件分页查询获取基础信息列表
    */
    PageResultSet<BasicDTO> findByPage(Page page);

	/**
	 * 获取基础信息的列表总数
	 */
	int getBasicListCount(Map condition);

	/**
	 * 新增基础信息
	 */
	int addBasic(BasicDTO basicDTO);

	/**
	 * 更新基础信息
	 */
	int updateBasic(BasicDTO basicDTO) throws Exception;

	/**
	 * 删除基础信息
	 */
	int deleteBasicById(int id);


}
