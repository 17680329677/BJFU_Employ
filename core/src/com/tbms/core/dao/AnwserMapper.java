package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.AnwserDTO;

/**
 * 类描述:     答案信息数据处理接口
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:18
 * 版本:       v1.0
 */
public interface AnwserMapper {

	/**
	 * 根据ID查询答案信息
	 */
	AnwserDTO getAnwserById(int id);

	/**
	 * 根据条件查询答案信息列表
	 */
	List<AnwserDTO> getAnwserList(Map<Object, Object> condition);

	/**
	 * 查询答案信息的列表总数
	 */
	int getAnwserListCount(Map<Object, Object> condition);

	/**
	 * 新增答案信息
	 */
	int addAnwser(AnwserDTO anwserDTO);

	/**
	 * 更新答案信息
	 */
	int updateAnwser(AnwserDTO anwserDTO);

	/**
	 * 删除答案信息
	 */
	int deleteAnwserById(int id);


}
