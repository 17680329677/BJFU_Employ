package com.tbms.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbms.core.dao.DifficultyMapper;
import com.tbms.core.dto.DifficultyDTO;
import com.tbms.core.service.DifficultyService;
import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     困难学生信息业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-03-20 15:24:10
 * 版本:       v1.0
 */
@Service("difficultyService")
public class DifficultyServiceImpl implements DifficultyService {


	@Resource
	private DifficultyMapper difficultyDAO;

	/**
	 * 根据ID获取困难学生信息
	 */
	public DifficultyDTO getDifficultyById(int id) {
		return difficultyDAO.getDifficultyById(id);
	}

	/**
	 * 根据学院分组统计困难学生
	 */
	public List<DifficultyDTO> getDifficultyListView(Map condition){
		return difficultyDAO.getDifficultyListView(condition);
	}

	/**
	 * 根据条件获取困难学生信息列表
	 */
	public List<DifficultyDTO> getDifficultyList(Map condition) {
		return difficultyDAO.getDifficultyList(condition);
	}

	/**
    * 根据条件获取分页困难学生信息列表
    */
    public PageResultSet<DifficultyDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = difficultyDAO.getDifficultyListCount(condition);
        PageResultSet<DifficultyDTO> resultSet = new PageResultSet<>();
        List<DifficultyDTO> difficultyPages = difficultyDAO.getDifficultyList(condition);
        resultSet.setRows(difficultyPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取困难学生信息的列表总数
	 */
	public int getDifficultyListCount(Map condition) {
		return difficultyDAO.getDifficultyListCount(condition);
	}

	/**
	 * 新增困难学生信息
	 */
	public int addDifficulty(DifficultyDTO difficultyDTO) {
		difficultyDAO.addDifficulty(difficultyDTO);
		return difficultyDTO.getId();
	}

	/**
     * 批量新增困难学生信息
     */
    @Transactional
    public int addDifficultyBatch(List<DifficultyDTO> list) throws Exception{
        return 0;
    }

	/**
	 * 更新困难学生信息
	 */
	public int updateDifficulty(DifficultyDTO difficultyDTO) throws Exception {
		return difficultyDAO.updateDifficulty(difficultyDTO);
	}

    /**
     * 批量更新困难学生信息
     */
	@Override
	@Transactional
	public int updateDifficultyBatch(Integer[] ids,DifficultyDTO difficultyDTO) throws Exception{
		return difficultyDAO.updateDifficultyBatch(ids,difficultyDTO);
	}

	/**
	 * 删除困难学生信息
	 */
	public int deleteDifficultyById(int id) {
		return difficultyDAO.deleteDifficultyById(id);
	}

	/**
	 *批量删除困难学生信息
	 */
	@Transactional
	public int deleteDifficultyBatch(Integer[] ids)throws Exception{
		return difficultyDAO.deleteDifficultyBatch(ids);
	}


}
