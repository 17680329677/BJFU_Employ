package com.tbms.core.dao;

import java.util.List;
import java.util.Map;

import com.tbms.core.dto.StudentDTO;
import org.apache.ibatis.annotations.Param;

/**
 * 类描述:     学生数据处理接口
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:34:30
 * 版本:       v1.0
 */
public interface StudentMapper {

	/**
	 * 根据ID查询学生
	 */
	StudentDTO getStudentById(int id);

	/**
	 * 根据Username查询
	 */
	StudentDTO getStudentByName(String username);

	/**
	 * 根据bind_account查询
	 */
	StudentDTO getStudentByBindAccount(String bind_account);

	/**
	 * 根据条件查询学生列表
	 */
	List<StudentDTO> getStudentList(Map<Object, Object> condition);

	/**
	 * 查询学生的列表总数
	 */
	int getStudentListCount(Map<Object, Object> condition);

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
	int updateStudent(StudentDTO studentDTO);

	/**
	 * 批量更新
	 */
	int updateStudentBatch(@Param("ids") Integer[] ids, @Param("student") StudentDTO student);

	/**
	 * 取消锁定
	 */
	int unlock(@Param("ids") Integer[] ids);

	/**
	 * 删除学生
	 */
	int deleteStudentById(int id);

	/**
	 * 批量删除学生
	 */
	int deleteStudentBatch(Integer[] ids);


}
