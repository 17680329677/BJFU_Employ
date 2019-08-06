package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.DifficultyDTO;
import org.apache.ibatis.annotations.Param;

/**
 * 类描述:     困难学生信息数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-03-20 15:24:10
 * 版本:       v1.0
 */
public interface DifficultyMapper {

	/**
	 * 根据ID查询困难学生信息
	 */
	DifficultyDTO getDifficultyById(int id);

	/**
	 * 根据学院分组统计困难学生
	 */
	List<DifficultyDTO> getDifficultyListView(Map<Object, Object> condition);

	/**
	 * 根据条件查询困难学生信息列表
	 */
	List<DifficultyDTO> getDifficultyList(Map<Object, Object> condition);

	/**
	 * 查询困难学生信息的列表总数
	 */
	int getDifficultyListCount(Map<Object, Object> condition);

	/**
	 * 新增困难学生信息
	 */
	int addDifficulty(DifficultyDTO difficultyDTO);

	/**
     * 批量新增困难学生信息
     */
    int addDifficultyBatch(List<DifficultyDTO> list);

	/**
	 * 更新困难学生信息
	 */
	int updateDifficulty(DifficultyDTO difficultyDTO);

    /**
    * 批量更新困难学生信息
    */
    int updateDifficultyBatch(@Param("ids") Integer[] ids, @Param("difficulty") DifficultyDTO difficulty);

	/**
	 * 删除困难学生信息
	 */
	int deleteDifficultyById(int id);

	/**
     * 批量删除困难学生信息
     */
    int deleteDifficultyBatch(Integer[] ids);


}
