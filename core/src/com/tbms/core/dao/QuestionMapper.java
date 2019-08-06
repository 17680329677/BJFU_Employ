package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.QuestionDTO;

/**
 * 类描述:     问题信息数据处理接口
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:19
 * 版本:       v1.0
 */
public interface QuestionMapper {

	/**
	 * 根据ID查询问题信息
	 */
	QuestionDTO getQuestionById(int id);

	/**
	 * 根据条件查询问题信息列表
	 */
	List<QuestionDTO> getQuestionList(Map<Object, Object> condition);

	/**
	 * 查询问题信息的列表总数
	 */
	int getQuestionListCount(Map<Object, Object> condition);

	/**
	 * 新增问题信息
	 */
	int addQuestion(QuestionDTO questionDTO);

	/**
	 * 更新问题信息
	 */
	int updateQuestion(QuestionDTO questionDTO);

	/**
	 * 删除问题信息
	 */
	int deleteQuestionById(int id);


}
