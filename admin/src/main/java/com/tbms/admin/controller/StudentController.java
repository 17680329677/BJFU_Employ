package com.tbms.admin.controller;

import com.tbms.core.common.annotation.SystemLog;
import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.common.util.DateUtil;
import com.tbms.core.common.util.ExcelUtil;
import com.tbms.core.dto.StudentDTO;
import com.tbms.core.service.BasicService;
import com.tbms.core.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;

import java.util.List;

/**
 * 类描述:     学生控制器
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:34:30
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @Resource
    private BasicService basicService;

    /**
     * 显示学生页面
     */
    @RequestMapping
    public String toStudent(Model model){
        //查询当前年度
        model.addAttribute("currentYear",DateUtil.currentYear(basicService));
        return "student";
    }

    /**
     * 就业信息管理模块学生基本信息页面
     */
    @RequestMapping("/difficulty")
    public String toStudentInfo(){
        return "difficulty";
    }


    /**
	 * 查询学生列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<StudentDTO> list(Page page) throws Exception {
        return studentService.findByPage(page);
    }

    /**
	 * 根据id查询学生
	 */
    @RequestMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable("id") Integer id) throws Exception {
        return studentService.getStudentById(id);
    }

    /**
     * 根据id查询学生
     */
    @ResponseBody
    @RequestMapping("/account/{account}")
    public Result getStudentByAccount(@PathVariable("account") String account) throws Exception {
        if(studentService.getStudentByName(account)==null) {
            return Result.Failure("0", "学号有误，请检查");
        }
        return Result.Success();
    }

    /**
	 * 根据id删除学生
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteStudent(@RequestParam("id") Integer[] ids) throws Exception {
        studentService.deleteStudentBatch(ids);
        return Result.Success();
    }

    /**
     * 根据id删除学生
     */
    @ResponseBody
    @RequestMapping("/deleteBatch")
    public Result deleteBatchStudent(@RequestParam("username") String username) throws Exception {
        Integer[] ids;
        int count = 0;
        if(!StringUtils.isEmpty(username)){
            String[] accounts = username.split("\\r\\n");
            if(accounts.length>0){
                ids = new Integer[accounts.length];
                for (int i = 0; i < accounts.length; i++) {
                    StudentDTO studentDTO = studentService.getStudentByName(accounts[i]);
                    if(studentDTO != null){
                        ids[i] = studentDTO.getId();
                    }else{
                        return Result.Failure("200", accounts[i]+"不存在,请检查学号");
                    }
                }
                count = studentService.deleteStudentBatch(ids);
            }
        }
        if(count == 0){
            return Result.Failure("200","删除失败，请检查数据");
        }
        return Result.Success("成功删除"+count+"条学生数据");
    }

    /**
	 * 新增学生
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated StudentDTO student,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             studentService.addStudent(student);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
     *批量导入
     */
    @ResponseBody
    @RequestMapping("/upload")
    public Result uploadExcel(@RequestParam("file") MultipartFile file) throws Exception{
        List<StudentDTO> list = ExcelUtil.importExcel(file,0,1,StudentDTO.class);
        try{
            studentService.addStudentBatch(list);
        }catch (Throwable throwable){
            return Result.Failure("0", "导入失败，请检查数据");
        }
        return Result.Success();
    }

    /**
	 * 更新学生
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updateStudent(@Validated StudentDTO student,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             studentService.updateStudent(student);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
     * 更新学生
     */
    @ResponseBody
    @RequestMapping("/updateBatch")
    public Result updateStudentBatch(@RequestParam("id") Integer[] ids,@Validated StudentDTO student,BindingResult bindingResult) throws Exception {
        try{
            if (bindingResult.hasErrors()){
                return Result.Failure(ResultCodeEnum.FieldError);
            }
            studentService.updateStudentBatch(ids,student);
        }catch (Throwable throwable){
            return Result.Failure("0", "请检查数据");
        }
        return Result.Success();
    }

    /**
     * 批量更新
     */
    @ResponseBody
    @RequestMapping("/unable")
    @SystemLog("注销学生")
    public Result unable(@RequestParam("id") Integer[] ids) throws Exception {
        try{
            StudentDTO student = new StudentDTO();
            student.setStatus(0);
            studentService.updateStudentBatch(ids,student);
        }catch (Throwable throwable){
            return Result.Failure("0", "注销失败");
        }
        return Result.Success();
    }
}
