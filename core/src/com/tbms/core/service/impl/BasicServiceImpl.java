package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.tbms.core.common.base.PageCondition;
import org.springframework.stereotype.Service;

import com.tbms.core.dao.BasicMapper;
import com.tbms.core.dto.BasicDTO;
import com.tbms.core.service.BasicService;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     基础信息业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:42:58
 * 版本:       v1.0
 */
@Service("basicService")
public class BasicServiceImpl implements BasicService {


	@Resource
	private BasicMapper basicDAO;

	/**
	 * 根据ID获取基础信息
	 */
	public BasicDTO getBasicById(int id) {
		return basicDAO.getBasicById(id);
	}

	/**
	 * 根据type获取基础信息
	 */
	public List<BasicDTO> getBasicByType(String type) {
		return basicDAO.getBasicByType(type);
	}

	/**
	 * 根据条件获取基础信息列表
	 */
	public List<BasicDTO> getBasicList(Map condition) {
		return basicDAO.getBasicList(condition);
	}

	/**
	 * 获取基础信息类型列表
	 */
	public List<BasicDTO> getBasicTypeList(){
		return basicDAO.getBasicTypeList();
	}

	/**
    * 根据条件获取分页基础信息列表
    */
    public PageResultSet<BasicDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = basicDAO.getBasicListCount(condition);
        PageResultSet<BasicDTO> resultSet = new PageResultSet<>();
        List<BasicDTO> basicPages = basicDAO.getBasicList(condition);
        resultSet.setRows(basicPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取基础信息的列表总数
	 */
	public int getBasicListCount(Map condition) {
		return basicDAO.getBasicListCount(condition);
	}

	/**
	 * 新增基础信息
	 */
	public int addBasic(BasicDTO basicDTO) {
		basicDAO.addBasic(basicDTO);
		return basicDTO.getId();
	}

	/**
	 * 更新基础信息
	 */
	public int updateBasic(BasicDTO basicDTO) throws Exception {
		return basicDAO.updateBasic(basicDTO);
	}

	/**
	 * 删除基础信息
	 */
	public int deleteBasicById(int id) {
		return basicDAO.deleteBasicById(id);
	}


}
