package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;
import com.tbms.core.common.util.DateUtil;
import com.tbms.core.common.util.ExcelUtil;
import com.tbms.core.dto.*;
import com.tbms.core.service.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述:     学生全部信息控制器
 * 创建人:     青枫
 * 创建时间:   2019-03-06 14:51:39
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/graduate")
public class GraduateController {
    @Resource
    private WorkService workService;
    @Resource
    private BasicService basicService;
    @Resource
    private StudentService studentService;
    @Resource
    private RoleService roleService;
    @Resource
    private EmployService employService;
    @Resource
    private RecordService recordService;
    /**
     * 显示学生全部信息页面
    */
    @RequestMapping
    public String toGraduate(Model model){

        //查询基本数据类型列表
        model.addAttribute("typeList",basicService.getBasicTypeList());

        Map condition = new HashMap();
        condition.put("status",1);

        //查询当前年度
        model.addAttribute("currentYear",DateUtil.currentYear(basicService));

        //查询民族
        condition.put("type","ethnicity");
        model.addAttribute("ethnicityList",basicService.getBasicList(condition));

        //查询政治面貌
        condition.put("type","political");
        model.addAttribute("politicalList",basicService.getBasicList(condition));

        //查询学历
        condition.put("type","education");
        model.addAttribute("educationList",basicService.getBasicList(condition));

        //查询学位
        condition.put("type","degree");
        model.addAttribute("degreeList",basicService.getBasicList(condition));

        //查询培养方式
        condition.put("type","training");
        model.addAttribute("trainingList",basicService.getBasicList(condition));

        //查询本科院校类别
        condition.put("type","undergraduateCat");
        model.addAttribute("undergraduateCatList",basicService.getBasicList(condition));

        //查询基层证书
        condition.put("type","certificate");
        model.addAttribute("certificateList",basicService.getBasicList(condition));

        //查询就业形式
        condition.put("type","form");
        model.addAttribute("employFormList",basicService.getBasicList(condition));

        //查询毕业去向
        condition.put("type","destination");
        model.addAttribute("destinationList",basicService.getBasicList(condition));

        //查询就业状态列表
        condition.put("type","employ");
        model.addAttribute("employList",basicService.getBasicList(condition));

        //查询工作职位类别
        condition.put("type","job");
        model.addAttribute("jobList",basicService.getBasicList(condition));

        //查询单位行业
        condition.put("type","industry");
        model.addAttribute("industryList",basicService.getBasicList(condition));

        //查询单位性质
        condition.put("type","property");
        model.addAttribute("propertyList",basicService.getBasicList(condition));

        //查询报到证签发类别
        condition.put("type","registerType");
        model.addAttribute("registerTypeList",basicService.getBasicList(condition));

        //查询审核状态列表
        condition.put("type","state");
        model.addAttribute("stateList",basicService.getBasicList(condition));

        //查询毕业结论
        condition.put("type","graduation");
        model.addAttribute("graduationList",basicService.getBasicList(condition));

        return "graduate";
    }

    /**
	 * 查询学生全部信息列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<WorkDTO> list(Page page) throws Exception {
        return workService.findByPage(page);
    }

    /**
     * 判断用户是否超级管理员
     */
    private boolean isRootUser(RoleService roleService,UserDTO user){
        int roleId = Integer.parseInt(user.getRoleId());
        if("root".equals(roleService.getRoleById(roleId).getRole())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 批量锁定
     */
    @ResponseBody
    @RequestMapping("/lock")
    public Result lock(@RequestParam("id") Integer[] ids,@RequestParam("status") Integer status,@RequestParam("remark") String remark) throws Exception{
        int count = 0;
        try{
            StudentDTO student = new StudentDTO();
            UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
            /**
             * 超级管理员锁定设置状态为2，以后只有超级管理员能修改
             * 院系管理员锁定设置状态为1，表示已审核
             * -1 表示审核未通过
             */
            if(status == -1){
                student.setStatus(-1);
            }else{
                if(isRootUser(roleService,user)){
                    student.setStatus(2);
                }else{
                    student.setStatus(1);
                }
            }
            if(remark != null){
                student.setRemark(remark);
            }
            count = studentService.updateStudentBatch(ids,student);
        }catch (Throwable throwable){
            return Result.Failure("0", "请检查数据");
        }
        if(count == 0){
            return Result.Failure("0","审核失败");
        }
        return Result.Success("成功审核"+count+"条学生信息");
    }

    /**
     * 批量取消锁定
     */
    @ResponseBody
    @RequestMapping("/unlock")
    public Result unlock(@RequestParam("id") Integer[] ids) throws Exception{
        int count;
        try{
            count = studentService.unlock(ids);
        }catch (Throwable throwable){
            return Result.Failure("0", "请检查数据");
        }
        if(count == 0){
            return Result.Failure("0","取消锁定失败");
        }
        return Result.Success("成功取消锁定"+count+"条学生信息");
    }

    /**
     * 批量设置
     */
    @ResponseBody
    @RequestMapping("/batch")
    public Result setBatch(@RequestParam("batchType") String batchType,@ModelAttribute StudentDTO student) throws Exception{
        int count = 0;
        //获取学生学号
        Integer[] ids;
        try{
            StudentDTO studentDTO;
            String[] accounts = student.getUsername().split("\\r\\n");
            //分割学号
            if(!StringUtils.isEmpty(accounts) && accounts.length > 0){
                ids = new Integer[accounts.length];
                //windows 替换回车符号
                for (int i = 0; i < accounts.length; i++) {
                    studentDTO = studentService.getStudentByName(accounts[i]);
                    if(studentDTO != null && studentDTO.getId() != 0){
                        ids[i] = studentDTO.getId();
                    }else{
                        return Result.Failure("200", accounts[i]+"不存在,请检查学号");
                    }
                }
                studentDTO = new StudentDTO();
                if("graduation".equals(batchType)){
                    studentDTO.setGraduation(student.getGraduation());
                    Integer year = Integer.parseInt(student.getGraduateDate().substring(0,4));
                    studentDTO.setGraduateYear(year);
                    studentDTO.setGraduate(student.getGraduate());
                }
                if("state".equals(batchType)){
                    UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
                    /**
                     * 超级管理员锁定设置状态为2，以后只有超级管理员能修改
                     * 院系管理员锁定设置状态为1，表示已审核
                     * -1 表示审核未通过
                     */
                    if(student.getStatus() == -1){
                        studentDTO.setStatus(-1);
                    }else{
                        if(isRootUser(roleService,user)){
                            studentDTO.setStatus(2);
                        }else{
                            studentDTO.setStatus(1);
                        }
                    }
                    studentDTO.setRemark(student.getRemark());
                }
                count = studentService.updateStudentBatch(ids,studentDTO);
            }
        }catch (Throwable throwable){
            return Result.Failure("0", "请检查数据");
        }
        if(count == 0){
            return Result.Failure("0","修改失败");
        }
        return Result.Success("成功修改"+count+"条学生信息");
    }

    /**
     * 批量更新毕业生信息
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestParam("id") Integer[] ids,@ModelAttribute StudentDTO student,@ModelAttribute EmployDTO employ,@ModelAttribute RecordDTO record, BindingResult bindingResult) throws Exception{
        int count = 0;
        try{
            if (bindingResult.hasErrors()){
                return Result.Failure(ResultCodeEnum.FieldError);
            }
            //更新基本信息
            if(student != null){
                if(student.getGraduation() != null ){
                    //从毕业日期中截取毕业年份
                    Integer year = Integer.parseInt(student.getGraduateDate().substring(0,4));
                    student.setGraduateYear(year);//毕业年份
                    if(student.getGraduate() == 0){
                        return Result.Failure("0", "请选择毕业结论");
                    }
                }
                count = studentService.updateStudentBatch(ids,student);
            }
            //更新就业信息
            if(employ != null && student.getUsername() != null){
                EmployDTO employTmp = employService.getEmployByAccount(student.getUsername());
                if(employTmp != null){
                    employ.setId(employTmp.getId());
                    employService.updateEmploy(employ);
                }else{
                    employService.addEmploy(employ);
                }
            }
            //更新档案信息
            if(record != null && student.getUsername() != null){
                RecordDTO recordTmp = recordService.getRecordByAccount(student.getUsername());
                if(recordTmp != null){
                    record.setId(recordTmp.getId());
                    recordService.updateRecord(record);
                }else{
                    recordService.addRecord(record);
                }
            }
        }catch (Throwable throwable){
            return Result.Failure("0", "请检查数据");
        }
        if(count == 0){
            return Result.Failure("0","已锁定不能修改");
        }
        return Result.Success("成功修改"+count+"条信息");
    }

    /**
     * 下载数据
     */
    @RequestMapping("/download/{graduateYear}")
    public void export(@PathVariable("graduateYear") String graduateYear,HttpServletResponse response) throws Exception{
        UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();

        Map condition = new HashMap();
        condition.put("graduateYear",graduateYear);

        if(!isRootUser(roleService,user)){
            condition.put("departCode",user.getDepartCode());
        }
        List<WorkDTO> list = workService.getWorkList(condition);
        String title;
        String head = user.getDepartName();
        if(list.size()>0){
            title = head+graduateYear+"年度学生毕业信息";
        }else{
            title = "本年度暂时没有学生毕业信息";
        }
        ExcelUtil.exportExcel(list,title,head,WorkDTO.class,title+".xls",response);
    }
}
