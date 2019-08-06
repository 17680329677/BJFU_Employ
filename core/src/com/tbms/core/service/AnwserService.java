package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.AnwserDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     答案信息业务接口
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:18
 * 版本:       v1.0
 */
public interface AnwserService {

	/**
	 * 根据ID获取答案信息
	 */
	AnwserDTO getAnwserById(int id);

	/**
	 * 根据条件获取答案信息列表
	 */
	List<AnwserDTO> getAnwserList(Map condition);

	/**
    * 根据条件分页查询获取答案信息列表
    */
    PageResultSet<AnwserDTO> findByPage(Page page);

	/**
	 * 获取答案信息的列表总数
	 */
	int getAnwserListCount(Map condition);

	/**
	 * 新增答案信息
	 */
	int addAnwser(AnwserDTO anwserDTO);

	/**
	 * 更新答案信息
	 */
	int updateAnwser(AnwserDTO anwserDTO) throws Exception;

	/**
	 * 删除答案信息
	 */
	int deleteAnwserById(int id);


}
