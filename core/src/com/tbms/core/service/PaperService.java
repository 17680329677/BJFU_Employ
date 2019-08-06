package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.PaperDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     问卷表业务接口
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:18
 * 版本:       v1.0
 */
public interface PaperService {

	/**
	 * 根据ID获取问卷表
	 */
	PaperDTO getPaperById(int id);

	/**
	 * 根据条件获取问卷表列表
	 */
	List<PaperDTO> getPaperList(Map condition);

	/**
    * 根据条件分页查询获取问卷表列表
    */
    PageResultSet<PaperDTO> findByPage(Page page);

	/**
	 * 获取问卷表的列表总数
	 */
	int getPaperListCount(Map condition);

	/**
	 * 新增问卷表
	 */
	int addPaper(PaperDTO paperDTO);

	/**
	 * 更新问卷表
	 */
	int updatePaper(PaperDTO paperDTO) throws Exception;

	/**
	 * 删除问卷表
	 */
	int deletePaperById(int id);

	/**
	 * 根据status查询问卷
	 */
	PaperDTO getPaperByStatus(int status);

	/**
	 * 根据paperType查询问卷
	 */
	PaperDTO getPaperByType(String paper_type);
}
