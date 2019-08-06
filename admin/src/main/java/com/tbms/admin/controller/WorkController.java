package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;

import com.tbms.core.common.base.ResultCodeEnum;
import com.tbms.core.common.util.DateUtil;
import com.tbms.core.dto.StudentDTO;
import com.tbms.core.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述:     学生全部信息控制器
 * 创建人:     青枫
 * 创建时间:   2019-03-06 14:51:39
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/work")
public class WorkController {
    @Resource
    private BasicService basicService;
    @Resource
    private StudentService studentService;
    /**
     * 显示学生全部信息页面
    */
    @RequestMapping
    public String toWork(Model model){
        //查询就业状态列表
        Map condition = new HashMap();
        //查询当前年度
        model.addAttribute("currentYear",DateUtil.currentYear(basicService));
        condition.put("type","employ");
        model.addAttribute("employList",basicService.getBasicList(condition));
        return "work";
    }

    /**
	 * 查询学生全部信息列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<StudentDTO> list(Page page) throws Exception {
        return studentService.findByPage(page);
    }

    /**
     * 批量更新学生就业状态
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestParam("id") Integer[] ids,StudentDTO student,BindingResult bindingResult) throws Exception{
        int count = 0;
        try{
            if (bindingResult.hasErrors()){
                return Result.Failure(ResultCodeEnum.FieldError);
            }
            //设置就业状态代码和就业状态
            if(student != null){
                count = studentService.updateStudentBatch(ids,student);
            }
            if(count == 0){
                return Result.Failure("0","修改失败");
            }
        }catch (Throwable throwable){
            return Result.Failure("0", "学生信息已审核，不能再修改");
        }
        return Result.Success("成功修改"+count+"条信息");
    }

}
