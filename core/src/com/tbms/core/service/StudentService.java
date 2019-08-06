package com.tbms.core.service;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.StudentDTO;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     学生业务接口
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:34:30
 * 版本:       v1.0
 */
public interface StudentService {

	/**
	 * 根据ID获取学生
	 */
	StudentDTO getStudentById(int id);

	/**
	 * 根据Username获取
	 */
	StudentDTO getStudentByName(String username);

	/**
	 * 根据bind_account获取
	 */
	StudentDTO getStudentByBindAccount(String bind_account);

	/**
	 * 根据条件获取学生列表
	 */
	List<StudentDTO> getStudentList(Map condition);

	/**
    * 根据条件分页查询获取学生列表
    */
    PageResultSet<StudentDTO> findByPage(Page page);

	/**
	 * 获取学生的列表总数
	 */
	int getStudentListCount(Map condition);

	/**
	 * 新增学生
	 */
	int addStudent(StudentDTO studentDTO);

	/**
	 * 批量新增
	 */
	int addStudentBatch(List<StudentDTO> list);

	/**
	 * 更新学生
	 */
	int updateStudent(StudentDTO studentDTO) throws Exception;

	/**
	 * 批量注销更新
	 */
	int updateStudentBatch(Integer[] ids,StudentDTO student) throws Exception ;

	/**
	 * 取消锁定
	 */
	int unlock(Integer[] ids) throws Exception ;

	/**
	 * 删除学生
	 */
	int deleteStudentById(int id) throws Exception;

	/**
	 * 批量删除学生
	 */
	int deleteStudentBatch(Integer[] ids) throws Exception;



}
