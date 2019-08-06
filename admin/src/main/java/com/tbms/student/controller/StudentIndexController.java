package com.tbms.student.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;
import com.tbms.core.common.util.DateUtil;
import com.tbms.core.dto.*;
import com.tbms.core.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/stu")
public class StudentIndexController {
    @Resource
    StudentService studentService;
    @Resource
    EmployService employService;
    @Resource
    RecordService recordService;
    @Resource
    BasicService basicService;
    @Resource
    WorkService workService;
    @Resource
    ProvinceService provinceService;

    @RequestMapping("/")
    public String toMain(Model model){
        StudentDTO studentDTO = (StudentDTO) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("status", studentDTO.getStatus());
        return "student/main";
    }

    /**
     * 查询学生全部信息列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public PageResultSet<WorkDTO> list(Page page) throws Exception {
        StudentDTO studentDTO = (StudentDTO) SecurityUtils.getSubject().getPrincipal();
        return workService.findByPage(page,studentDTO.getUsername());
    }

    @RequestMapping("/self")
    public String toSelf(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        StudentDTO studentDTO = (StudentDTO) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("currentStudent", studentService.getStudentById(studentDTO.getId()));
        return "student/self";
    }

    @RequestMapping("/info")
    public String toInfo(Model model) throws Exception {

        //查询基本数据类型列表
        model.addAttribute("typeList",basicService.getBasicTypeList());

        Map condition = new HashMap();
        condition.put("status",1);

        //查询民族
        condition.put("type","ethnicity");
        model.addAttribute("ethnicityList",basicService.getBasicList(condition));

        //查询政治面貌
        condition.put("type","political");
        model.addAttribute("politicalList",basicService.getBasicList(condition));

        //查询培养方式
        condition.put("type","training");
        model.addAttribute("trainingList",basicService.getBasicList(condition));

        //查询本科院校类别
        condition.put("type","undergraduateCat");
        model.addAttribute("undergraduateCatList",basicService.getBasicList(condition));

        //查询就业形式
        condition.put("type","form");
        model.addAttribute("employFormList",basicService.getBasicList(condition));

        //查询毕业去向
        condition.put("type","destination");
        model.addAttribute("destinationList",basicService.getBasicList(condition));

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

        //查询省份信息
        Map provinceCondition = new HashMap();
        model.addAttribute("provinceList", provinceService.getProvinceList(provinceCondition));

        // 查询学生状态状态
        StudentDTO studentDTO = (StudentDTO) SecurityUtils.getSubject().getPrincipal();
        StudentDTO student = studentService.getStudentById(studentDTO.getId());
        model.addAttribute("status", student.getStatus());
        return "student/stuInfo";
    }

    /**
     * 批量更新毕业生信息
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@ModelAttribute StudentDTO student, @ModelAttribute EmployDTO employ, @ModelAttribute RecordDTO record, BindingResult bindingResult) throws Exception{
        int count = 0;
        try{
            if (bindingResult.hasErrors()){
                return Result.Failure(ResultCodeEnum.FieldError);
            }
            StudentDTO studentDTO = (StudentDTO) SecurityUtils.getSubject().getPrincipal();
            //已审核状态不能再提交
            if(studentService.getStudentByName(studentDTO.getUsername()).getStatus()>0){
                return Result.Failure("200","已审核不能修改");
            }else{
                //待审核
                student.setStatus(-2);
            }
            //更新基本信息
            if(student != null && student.getId() != 0){
                count = studentService.updateStudent(student);
            }
            //更新就业信息
            if(employ != null){
                EmployDTO employTmp = employService.getEmployByAccount(studentDTO.getUsername());
                if(employTmp != null){
                    employ.setId(employTmp.getId());
                    employService.updateEmploy(employ);
                }else{
                    employService.addEmploy(employ);
                }
            }
            //更新档案信息
            if(record != null){
                RecordDTO recordTmp = recordService.getRecordByAccount(studentDTO.getUsername());
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
            return Result.Failure("0","修改失败");
        }
        return Result.Success("成功修改信息");
    }

    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}
