package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tbms.core.dao.PaperMapper;
import com.tbms.core.dto.PaperDTO;
import com.tbms.core.service.PaperService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     问卷表业务接口实现类
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:18
 * 版本:       v1.0
 */
@Service("paperService")
public class PaperServiceImpl implements PaperService {


	@Resource
	private PaperMapper paperDAO;

	/**
	 * 根据ID获取问卷表
	 */
	public PaperDTO getPaperById(int id) {
		return paperDAO.getPaperById(id);
	}

	/**
	 * 根据条件获取问卷表列表
	 */
	public List<PaperDTO> getPaperList(Map condition) {
		return paperDAO.getPaperList(condition);
	}

	/**
    * 根据条件获取分页问卷表列表
    */
    public PageResultSet<PaperDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = paperDAO.getPaperListCount(condition);
        PageResultSet<PaperDTO> resultSet = new PageResultSet<>();
        List<PaperDTO> paperPages = paperDAO.getPaperList(condition);
        resultSet.setRows(paperPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	@Override
	public PaperDTO getPaperByType(String paper_type) { return paperDAO.getPaperByType(paper_type); }

	/**
	 * 获取问卷表的列表总数
	 */
	public int getPaperListCount(Map condition) {
		return paperDAO.getPaperListCount(condition);
	}

	/**
	 * 新增问卷表
	 */
	public int addPaper(PaperDTO paperDTO) {
		paperDAO.addPaper(paperDTO);
		return paperDTO.getId();
	}

	/**
	 * 更新问卷表
	 */
	public int updatePaper(PaperDTO paperDTO) throws Exception {
		return paperDAO.updatePaper(paperDTO);
	}

	/**
	 * 删除问卷表
	 */
	public int deletePaperById(int id) {
		return paperDAO.deletePaperById(id);
	}

	/**
	 * 根据status查询问卷
	 */
	public PaperDTO getPaperByStatus(int status) { return paperDAO.getPaperByStatus(status); }
}
