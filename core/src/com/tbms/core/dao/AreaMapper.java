package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.AreaDTO;

/**
 * 类描述:     数据处理接口
 * 创建人:     dhz
 * 创建时间:   2019-07-12 20:44:40
 * 版本:       v1.0
 */
public interface AreaMapper {

	/**
	 * 根据ID查询
	 */
	AreaDTO getAreaById(int id);

	/**
	 * 根据条件查询列表
	 */
	List<AreaDTO> getAreaList(Map<Object, Object> condition);

	/**
	 * 查询的列表总数
	 */
	int getAreaListCount(Map<Object, Object> condition);

	/**
	 * 新增
	 */
	int addArea(AreaDTO areaDTO);

	/**
     * 批量新增
     */
    int addAreaBatch(List<AreaDTO> list);

	/**
	 * 更新
	 */
	int updateArea(AreaDTO areaDTO);


	/**
	 * 删除
	 */
	int deleteAreaById(int id);

	/**
     * 批量删除
     */
    int deleteAreaBatch(Integer[] ids);


}
