package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbms.core.dao.ProvinceMapper;
import com.tbms.core.dto.ProvinceDTO;
import com.tbms.core.service.ProvinceService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口实现类
 * 创建人:     dhz
 * 创建时间:   2019-07-12 20:44:41
 * 版本:       v1.0
 */
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {


	@Resource
	private ProvinceMapper provinceDAO;

	/**
	 * 根据ID获取
	 */
	public ProvinceDTO getProvinceById(int id) {
		return provinceDAO.getProvinceById(id);
	}

	/**
	 * 根据条件获取列表
	 */
	public List<ProvinceDTO> getProvinceList(Map condition) {
		return provinceDAO.getProvinceList(condition);
	}

	/**
    * 根据条件获取分页列表
    */
    public PageResultSet<ProvinceDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = provinceDAO.getProvinceListCount(condition);
        PageResultSet<ProvinceDTO> resultSet = new PageResultSet<>();
        List<ProvinceDTO> provincePages = provinceDAO.getProvinceList(condition);
        resultSet.setRows(provincePages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取的列表总数
	 */
	public int getProvinceListCount(Map condition) {
		return provinceDAO.getProvinceListCount(condition);
	}

	/**
	 * 新增
	 */
	public int addProvince(ProvinceDTO provinceDTO) {
		provinceDAO.addProvince(provinceDTO);
		return provinceDTO.getId();
	}

	/**
     * 批量新增
     */
    @Transactional
    public int addProvinceBatch(List<ProvinceDTO> list) throws Exception{
        return 0;
    }

	/**
	 * 更新
	 */
	public int updateProvince(ProvinceDTO provinceDTO) throws Exception {
		return provinceDAO.updateProvince(provinceDTO);
	}

    /**
     * 批量更新
     */
//	@Override
//	@Transactional
//	public int updateProvinceBatch(Integer[] ids,ProvinceDTO provinceDTO) throws Exception{
//		return provinceDAO.updateProvinceBatch(ids,provinceDTO);
//	}

	/**
	 * 删除
	 */
	public int deleteProvinceById(int id) {
		return provinceDAO.deleteProvinceById(id);
	}

	/**
	 *批量删除
	 */
	@Transactional
	public int deleteProvinceBatch(Integer[] ids)throws Exception{
		return provinceDAO.deleteProvinceBatch(ids);
	}


}
