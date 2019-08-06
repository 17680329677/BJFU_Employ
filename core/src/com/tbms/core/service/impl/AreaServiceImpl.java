package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbms.core.dao.AreaMapper;
import com.tbms.core.dto.AreaDTO;
import com.tbms.core.service.AreaService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     业务接口实现类
 * 创建人:     dhz
 * 创建时间:   2019-07-12 20:44:40
 * 版本:       v1.0
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService {


	@Resource
	private AreaMapper areaDAO;

	/**
	 * 根据ID获取
	 */
	public AreaDTO getAreaById(int id) {
		return areaDAO.getAreaById(id);
	}

	/**
	 * 根据条件获取列表
	 */
	public List<AreaDTO> getAreaList(Map condition) {
		return areaDAO.getAreaList(condition);
	}

	/**
    * 根据条件获取分页列表
    */
    public PageResultSet<AreaDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = areaDAO.getAreaListCount(condition);
        PageResultSet<AreaDTO> resultSet = new PageResultSet<>();
        List<AreaDTO> areaPages = areaDAO.getAreaList(condition);
        resultSet.setRows(areaPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取的列表总数
	 */
	public int getAreaListCount(Map condition) {
		return areaDAO.getAreaListCount(condition);
	}

	/**
	 * 新增
	 */
	public int addArea(AreaDTO areaDTO) {
		areaDAO.addArea(areaDTO);
		return areaDTO.getId();
	}

	/**
     * 批量新增
     */
    @Transactional
    public int addAreaBatch(List<AreaDTO> list) throws Exception{
        return 0;
    }

	/**
	 * 更新
	 */
	public int updateArea(AreaDTO areaDTO) throws Exception {
		return areaDAO.updateArea(areaDTO);
	}

	/**
	 * 删除
	 */
	public int deleteAreaById(int id) {
		return areaDAO.deleteAreaById(id);
	}

	/**
	 *批量删除
	 */
	@Transactional
	public int deleteAreaBatch(Integer[] ids)throws Exception{
		return areaDAO.deleteAreaBatch(ids);
	}


}
