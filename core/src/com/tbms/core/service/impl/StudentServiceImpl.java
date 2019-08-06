package com.tbms.core.service.impl;

import java.util.*;

import javax.annotation.Resource;

import com.tbms.core.common.base.PageCondition;
import com.tbms.core.common.util.PasswordUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbms.core.dao.StudentMapper;
import com.tbms.core.dto.StudentDTO;
import com.tbms.core.service.StudentService;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Page;

/**
 * 类描述:     学生业务接口实现类
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:34:30
 * 版本:       v1.0
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {


	@Resource
	private StudentMapper studentDAO;

	/**
	 * 根据ID获取学生
	 */
	public StudentDTO getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	/**
	 * 根据Username获取
	 */
	public StudentDTO getStudentByName(String username) {
		return studentDAO.getStudentByName(username);
	}

	/**
	 * 根据Username获取
	 */
	public StudentDTO getStudentByBindAccount(String bind_account) { return studentDAO.getStudentByBindAccount(bind_account); }

	/**
	 * 根据条件获取学生列表
	 */
	public List<StudentDTO> getStudentList(Map condition) {
		return studentDAO.getStudentList(condition);
	}

	/**
    * 根据条件获取分页学生列表
    */
    public PageResultSet<StudentDTO> findByPage(Page page) {
    	Map<Object, Object> condition = PageCondition.util(page);
        int count = studentDAO.getStudentListCount(condition);
        PageResultSet<StudentDTO> resultSet = new PageResultSet<>();
        List<StudentDTO> studentPages = studentDAO.getStudentList(condition);
        resultSet.setRows(studentPages);
        resultSet.setTotal(count);
        return resultSet;
    }

	/**
	 * 获取学生的列表总数
	 */
	public int getStudentListCount(Map condition) {
		return studentDAO.getStudentListCount(condition);
	}

	/**
	 * 新增学生
	 */
	public int addStudent(StudentDTO studentDTO) {
		studentDAO.addStudent(studentDTO);
		return studentDTO.getId();
	}

	/**
	 * 批量新增
	 */
	@Transactional
	public int addStudentBatch(List<StudentDTO> list) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setPassword(PasswordUtil.hashPwd(list.get(i).getPassword(),list.get(i).getUsername()));
			list.get(i).setStatus(1);
		}
		return studentDAO.addStudentBatch(list);
	}

	/**
	 * 更新学生
	 */
	public int updateStudent(StudentDTO studentDTO) throws Exception {
		String pwd = studentDTO.getPassword();
		if(pwd != null){
			studentDTO.setPassword(PasswordUtil.hashPwd(pwd,studentDTO.getCredentialsSalt()));
		}
		return studentDAO.updateStudent(studentDTO);
	}

	/**
	 * 批量更新
	 */
	@Transactional
	public int updateStudentBatch(Integer[] ids,StudentDTO student) throws Exception {
		return studentDAO.updateStudentBatch(ids,student);
	}

	/**
	 * 取消锁定
	 */
	@Transactional
	public int unlock(Integer[] ids){
		return studentDAO.unlock(ids);
	}

	/**
	 * 删除学生
	 */
	public int deleteStudentById(int id) throws Exception {
		return studentDAO.deleteStudentById(id);
	}

	/**
	 *批量删除学生
	 */
	@Transactional
	public int deleteStudentBatch(Integer[] ids)throws Exception{
		return studentDAO.deleteStudentBatch(ids);
	}


}
