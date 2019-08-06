package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.PaperDTO;

/**
 * 类描述:     问卷表数据处理接口
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:18
 * 版本:       v1.0
 */
public interface PaperMapper {

	/**
	 * 根据ID查询问卷表
	 */
	PaperDTO getPaperById(int id);

	/**
	 * 根据条件查询问卷表列表
	 */
	List<PaperDTO> getPaperList(Map<Object, Object> condition);

	/**
	 * 查询问卷表的列表总数
	 */
	int getPaperListCount(Map<Object, Object> condition);

	/**
	 * 新增问卷表
	 */
	int addPaper(PaperDTO paperDTO);

	/**
	 * 更新问卷表
	 */
	int updatePaper(PaperDTO paperDTO);

	/**
	 * 删除问卷表
	 */
	int deletePaperById(int id);

	/**
	 * 根据Status查询问卷
	 */
	PaperDTO getPaperByStatus(int status);

	/**
	 * 根据paperType查询问卷
	 */
	PaperDTO getPaperByType(String paper_type);
}
