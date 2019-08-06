package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.tbms.core.common.base.PageCondition;
import org.springframework.stereotype.Service;

import com.tbms.core.dao.MajorMapper;
import com.tbms.core.dto.MajorDTO;
import com.tbms.core.service.MajorService;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     专业业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:43:43
 * 版本:       v1.0
 */
@Service("majorService")
public class MajorServiceImpl implements MajorService {


	@Resource
	private MajorMapper majorDAO;

	/**
	 * 根据ID获取专业
	 */
	public MajorDTO getMajorById(int id) {
		return majorDAO.getMajorById(id);
	}

	/**
	 * 根据条件获取专业列表
	 */
	public List<MajorDTO> getMajorList(Map condition) {
		return majorDAO.getMajorList(condition);
	}

	/**
    * 根据条件获取分页专业列表
    */
    public PageResultSet<MajorDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = majorDAO.getMajorListCount(condition);
        PageResultSet<MajorDTO> resultSet = new PageResultSet<>();
        List<MajorDTO> majorPages = majorDAO.getMajorList(condition);
        resultSet.setRows(majorPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取专业的列表总数
	 */
	public int getMajorListCount(Map condition) {
		return majorDAO.getMajorListCount(condition);
	}

	/**
	 * 新增专业
	 */
	public int addMajor(MajorDTO majorDTO) {
		majorDAO.addMajor(majorDTO);
		return majorDTO.getId();
	}

	/**
	 * 更新专业
	 */
	public int updateMajor(MajorDTO majorDTO) throws Exception {
		return majorDAO.updateMajor(majorDTO);
	}

	/**
	 * 删除专业
	 */
	public int deleteMajorById(int id) {
		return majorDAO.deleteMajorById(id);
	}


}
