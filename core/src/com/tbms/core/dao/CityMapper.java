package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.CityDTO;

/**
 * 类描述:     数据处理接口
 * 创建人:     dhz
 * 创建时间:   2019-07-12 20:44:40
 * 版本:       v1.0
 */
public interface CityMapper {

	/**
	 * 根据ID查询
	 */
	CityDTO getCityById(int id);

	/**
	 * 根据条件查询列表
	 */
	List<CityDTO> getCityList(Map<Object, Object> condition);

	/**
	 * 查询的列表总数
	 */
	int getCityListCount(Map<Object, Object> condition);

	/**
	 * 新增
	 */
	int addCity(CityDTO cityDTO);

	/**
     * 批量新增
     */
    int addCityBatch(List<CityDTO> list);

	/**
	 * 更新
	 */
	int updateCity(CityDTO cityDTO);

	/**
	 * 删除
	 */
	int deleteCityById(int id);

	/**
     * 批量删除
     */
    int deleteCityBatch(Integer[] ids);


}
