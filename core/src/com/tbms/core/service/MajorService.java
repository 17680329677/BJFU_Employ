package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.MajorDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     专业业务接口
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:43:43
 * 版本:       v1.0
 */
public interface MajorService {

	/**
	 * 根据ID获取专业
	 */
	MajorDTO getMajorById(int id);

	/**
	 * 根据条件获取专业列表
	 */
	List<MajorDTO> getMajorList(Map condition);

	/**
    * 根据条件分页查询获取专业列表
    */
    PageResultSet<MajorDTO> findByPage(Page page);

	/**
	 * 获取专业的列表总数
	 */
	int getMajorListCount(Map condition);

	/**
	 * 新增专业
	 */
	int addMajor(MajorDTO majorDTO);

	/**
	 * 更新专业
	 */
	int updateMajor(MajorDTO majorDTO) throws Exception;

	/**
	 * 删除专业
	 */
	int deleteMajorById(int id);


}
