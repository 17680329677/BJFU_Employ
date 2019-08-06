package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.ProvinceDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口
 * 创建人:     dhz
 * 创建时间:   2019-07-12 20:44:41
 * 版本:       v1.0
 */
public interface ProvinceService {

	/**
	 * 根据ID获取
	 */
	ProvinceDTO getProvinceById(int id);

	/**
	 * 根据条件获取列表
	 */
	List<ProvinceDTO> getProvinceList(Map condition);

	/**
    * 根据条件分页查询获取列表
    */
    PageResultSet<ProvinceDTO> findByPage(Page page);

	/**
	 * 获取的列表总数
	 */
	int getProvinceListCount(Map condition);

	/**
	 * 新增
	 */
	int addProvince(ProvinceDTO provinceDTO);

	/**
     * 批量添加
     */
    int addProvinceBatch(List<ProvinceDTO> list) throws Exception;

	/**
	 * 更新
	 */
	int updateProvince(ProvinceDTO provinceDTO) throws Exception;


	/**
	 * 删除
	 */
	int deleteProvinceById(int id) throws Exception;

	/**
     * 批量删除
     */
    int deleteProvinceBatch(Integer[] ids) throws Exception;


}
