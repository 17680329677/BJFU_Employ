package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.QuestionDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     问题信息业务接口
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:19
 * 版本:       v1.0
 */
public interface QuestionService {

	/**
	 * 根据ID获取问题信息
	 */
	QuestionDTO getQuestionById(int id);

	/**
	 * 根据条件获取问题信息列表
	 */
	List<QuestionDTO> getQuestionList(Map condition);

	/**
    * 根据条件分页查询获取问题信息列表
    */
    PageResultSet<QuestionDTO> findByPage(Page page);

	/**
	 * 根据分页信息及问卷ID获取问题信息列表
	 */
	PageResultSet<QuestionDTO> findByPageAndPaper(Page page, Integer id);

	/**
	 * 获取问题信息的列表总数
	 */
	int getQuestionListCount(Map condition);

	/**
	 * 新增问题信息
	 */
	int addQuestion(QuestionDTO questionDTO);

	/**
	 * 更新问题信息
	 */
	int updateQuestion(QuestionDTO questionDTO) throws Exception;

	/**
	 * 删除问题信息
	 */
	int deleteQuestionById(int id);


}
