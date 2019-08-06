package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.CityDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口
 * 创建人:     dhz
 * 创建时间:   2019-07-12 20:44:40
 * 版本:       v1.0
 */
public interface CityService {

	/**
	 * 根据ID获取
	 */
	CityDTO getCityById(int id);

	/**
	 * 根据条件获取列表
	 */
	List<CityDTO> getCityList(Map condition);

	/**
    * 根据条件分页查询获取列表
    */
    PageResultSet<CityDTO> findByPage(Page page);

	/**
	 * 获取的列表总数
	 */
	int getCityListCount(Map condition);

	/**
	 * 新增
	 */
	int addCity(CityDTO cityDTO);

	/**
     * 批量添加
     */
    int addCityBatch(List<CityDTO> list) throws Exception;

	/**
	 * 更新
	 */
	int updateCity(CityDTO cityDTO) throws Exception;

	/**
	 * 删除
	 */
	int deleteCityById(int id) throws Exception;

	/**
     * 批量删除
     */
    int deleteCityBatch(Integer[] ids) throws Exception;


}
