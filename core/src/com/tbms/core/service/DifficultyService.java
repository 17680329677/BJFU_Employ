package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.DifficultyDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     困难学生信息业务接口
 * 创建人:     青枫
 * 创建时间:   2019-03-20 15:24:10
 * 版本:       v1.0
 */
public interface DifficultyService {

	/**
	 * 根据ID获取困难学生信息
	 */
	DifficultyDTO getDifficultyById(int id);

	/**
	 * 根据学院分组统计困难学生
	 */
	List<DifficultyDTO> getDifficultyListView(Map condition);

	/**
	 * 根据条件获取困难学生信息列表
	 */
	List<DifficultyDTO> getDifficultyList(Map condition);

	/**
    * 根据条件分页查询获取困难学生信息列表
    */
    PageResultSet<DifficultyDTO> findByPage(Page page);

	/**
	 * 获取困难学生信息的列表总数
	 */
	int getDifficultyListCount(Map condition);

	/**
	 * 新增困难学生信息
	 */
	int addDifficulty(DifficultyDTO difficultyDTO);

	/**
     * 批量添加困难学生信息
     */
    int addDifficultyBatch(List<DifficultyDTO> list) throws Exception;

	/**
	 * 更新困难学生信息
	 */
	int updateDifficulty(DifficultyDTO difficultyDTO) throws Exception;

	/**
     * 批量更新困难学生信息
     */
    int updateDifficultyBatch(Integer[] ids, DifficultyDTO difficultyDTO) throws Exception;

	/**
	 * 删除困难学生信息
	 */
	int deleteDifficultyById(int id) throws Exception;

	/**
     * 批量删除困难学生信息
     */
    int deleteDifficultyBatch(Integer[] ids) throws Exception;


}
