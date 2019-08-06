package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.ProvinceDTO;

/**
 * 类描述:     数据处理接口
 * 创建人:     dhz
 * 创建时间:   2019-07-12 20:44:41
 * 版本:       v1.0
 */
public interface ProvinceMapper {

	/**
	 * 根据ID查询
	 */
	ProvinceDTO getProvinceById(int id);

	/**
	 * 根据条件查询列表
	 */
	List<ProvinceDTO> getProvinceList(Map<Object, Object> condition);

	/**
	 * 查询的列表总数
	 */
	int getProvinceListCount(Map<Object, Object> condition);

	/**
	 * 新增
	 */
	int addProvince(ProvinceDTO provinceDTO);

	/**
     * 批量新增
     */
    int addProvinceBatch(List<ProvinceDTO> list);

	/**
	 * 更新
	 */
	int updateProvince(ProvinceDTO provinceDTO);

	/**
	 * 删除
	 */
	int deleteProvinceById(int id);

	/**
     * 批量删除
     */
    int deleteProvinceBatch(Integer[] ids);


}
