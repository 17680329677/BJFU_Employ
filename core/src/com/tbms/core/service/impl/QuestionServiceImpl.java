package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tbms.core.dao.QuestionMapper;
import com.tbms.core.dto.QuestionDTO;
import com.tbms.core.service.QuestionService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     问题信息业务接口实现类
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:19
 * 版本:       v1.0
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {


	@Resource
	private QuestionMapper questionDAO;

	/**
	 * 根据ID获取问题信息
	 */
	public QuestionDTO getQuestionById(int id) {
		return questionDAO.getQuestionById(id);
	}

	/**
	 * 根据条件获取问题信息列表
	 */
	public List<QuestionDTO> getQuestionList(Map condition) {
		return questionDAO.getQuestionList(condition);
	}

	/**
    * 根据条件获取分页问题信息列表
    */
    public PageResultSet<QuestionDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = questionDAO.getQuestionListCount(condition);
        PageResultSet<QuestionDTO> resultSet = new PageResultSet<>();
        List<QuestionDTO> questionPages = questionDAO.getQuestionList(condition);
        resultSet.setRows(questionPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 根据分页信息及问卷ID获取问题信息列表
	 */
	public PageResultSet<QuestionDTO> findByPageAndPaper(Page page, Integer id) {
		Map<Object, Object> condition = PageCondition.util(page);
		condition.put("paperId", id);
		int count = questionDAO.getQuestionListCount(condition);
		PageResultSet<QuestionDTO> resultSet = new PageResultSet<>();
		List<QuestionDTO> questionPages = questionDAO.getQuestionList(condition);
		resultSet.setRows(questionPages);
		resultSet.setTotal(count);
		return resultSet;
	}

	/**
	 * 获取问题信息的列表总数
	 */
	public int getQuestionListCount(Map condition) {
		return questionDAO.getQuestionListCount(condition);
	}

	/**
	 * 新增问题信息
	 */
	public int addQuestion(QuestionDTO questionDTO) {
		questionDAO.addQuestion(questionDTO);
		return questionDTO.getId();
	}

	/**
	 * 更新问题信息
	 */
	public int updateQuestion(QuestionDTO questionDTO) throws Exception {
		return questionDAO.updateQuestion(questionDTO);
	}

	/**
	 * 删除问题信息
	 */
	public int deleteQuestionById(int id) {
		return questionDAO.deleteQuestionById(id);
	}


}
