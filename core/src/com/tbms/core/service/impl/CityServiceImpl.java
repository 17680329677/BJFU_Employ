package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbms.core.dao.CityMapper;
import com.tbms.core.dto.CityDTO;
import com.tbms.core.service.CityService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口实现类
 * 创建人:     dhz
 * 创建时间:   2019-07-12 20:44:40
 * 版本:       v1.0
 */
@Service("cityService")
public class CityServiceImpl implements CityService {


	@Resource
	private CityMapper cityDAO;

	/**
	 * 根据ID获取
	 */
	public CityDTO getCityById(int id) {
		return cityDAO.getCityById(id);
	}

	/**
	 * 根据条件获取列表
	 */
	public List<CityDTO> getCityList(Map condition) {
		return cityDAO.getCityList(condition);
	}

	/**
    * 根据条件获取分页列表
    */
    public PageResultSet<CityDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = cityDAO.getCityListCount(condition);
        PageResultSet<CityDTO> resultSet = new PageResultSet<>();
        List<CityDTO> cityPages = cityDAO.getCityList(condition);
        resultSet.setRows(cityPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取的列表总数
	 */
	public int getCityListCount(Map condition) {
		return cityDAO.getCityListCount(condition);
	}

	/**
	 * 新增
	 */
	public int addCity(CityDTO cityDTO) {
		cityDAO.addCity(cityDTO);
		return cityDTO.getId();
	}

	/**
     * 批量新增
     */
    @Transactional
    public int addCityBatch(List<CityDTO> list) throws Exception{
        return 0;
    }

	/**
	 * 更新
	 */
	public int updateCity(CityDTO cityDTO) throws Exception {
		return cityDAO.updateCity(cityDTO);
	}

    /**
     * 批量更新
     */
//	@Override
//	@Transactional
//	public int updateCityBatch(Integer[] ids,CityDTO cityDTO) throws Exception{
//		return cityDAO.updateCityBatch(ids,cityDTO);
//	}

	/**
	 * 删除
	 */
	public int deleteCityById(int id) {
		return cityDAO.deleteCityById(id);
	}

	/**
	 *批量删除
	 */
	@Transactional
	public int deleteCityBatch(Integer[] ids)throws Exception{
		return cityDAO.deleteCityBatch(ids);
	}


}
