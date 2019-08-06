package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tbms.core.dao.AnwserMapper;
import com.tbms.core.dto.AnwserDTO;
import com.tbms.core.service.AnwserService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     答案信息业务接口实现类
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:18
 * 版本:       v1.0
 */
@Service("anwserService")
public class AnwserServiceImpl implements AnwserService {


	@Resource
	private AnwserMapper anwserDAO;

	/**
	 * 根据ID获取答案信息
	 */
	public AnwserDTO getAnwserById(int id) {
		return anwserDAO.getAnwserById(id);
	}

	/**
	 * 根据条件获取答案信息列表
	 */
	public List<AnwserDTO> getAnwserList(Map condition) {
		return anwserDAO.getAnwserList(condition);
	}

	/**
    * 根据条件获取分页答案信息列表
    */
    public PageResultSet<AnwserDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = anwserDAO.getAnwserListCount(condition);
        PageResultSet<AnwserDTO> resultSet = new PageResultSet<>();
        List<AnwserDTO> anwserPages = anwserDAO.getAnwserList(condition);
        resultSet.setRows(anwserPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取答案信息的列表总数
	 */
	public int getAnwserListCount(Map condition) {
		return anwserDAO.getAnwserListCount(condition);
	}

	/**
	 * 新增答案信息
	 */
	public int addAnwser(AnwserDTO anwserDTO) {
		anwserDAO.addAnwser(anwserDTO);
		return anwserDTO.getId();
	}

	/**
	 * 更新答案信息
	 */
	public int updateAnwser(AnwserDTO anwserDTO) throws Exception {
		return anwserDAO.updateAnwser(anwserDTO);
	}

	/**
	 * 删除答案信息
	 */
	public int deleteAnwserById(int id) {
		return anwserDAO.deleteAnwserById(id);
	}


}
