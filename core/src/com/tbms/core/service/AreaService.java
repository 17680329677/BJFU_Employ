package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.AreaDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口
 * 创建人:     dhz
 * 创建时间:   2019-07-12 20:44:40
 * 版本:       v1.0
 */
public interface AreaService {

	/**
	 * 根据ID获取
	 */
	AreaDTO getAreaById(int id);

	/**
	 * 根据条件获取列表
	 */
	List<AreaDTO> getAreaList(Map condition);

	/**
    * 根据条件分页查询获取列表
    */
    PageResultSet<AreaDTO> findByPage(Page page);

	/**
	 * 获取的列表总数
	 */
	int getAreaListCount(Map condition);

	/**
	 * 新增
	 */
	int addArea(AreaDTO areaDTO);

	/**
     * 批量添加
     */
    int addAreaBatch(List<AreaDTO> list) throws Exception;

	/**
	 * 更新
	 */
	int updateArea(AreaDTO areaDTO) throws Exception;

	/**
	 * 删除
	 */
	int deleteAreaById(int id) throws Exception;

	/**
     * 批量删除
     */
    int deleteAreaBatch(Integer[] ids) throws Exception;


}
