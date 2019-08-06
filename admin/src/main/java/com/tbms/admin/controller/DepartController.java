package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.DepartDTO;
import com.tbms.core.service.DepartService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 类描述:     部门管理控制器
 * 创建人:     青枫
 * 创建时间:   2019-02-02 16:21:41
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/depart")
public class DepartController {
    @Resource
    private DepartService departService;

    /**
     * 显示部门管理页面
    */
    @RequestMapping
    public String toDepart(){
            return "depart";
    }

    /**
	 * 查询部门管理列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<DepartDTO> list(Page page) throws Exception {
        return departService.findByPage(page);
    }

    /**
	 * 根据id查询部门管理
	 */
    @RequestMapping("/{id}")
    public DepartDTO getDepartById(@PathVariable("id") Integer id) throws Exception {
        return departService.getDepartById(id);
    }

    /**
	 * 根据id删除部门管理
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteDepart(@RequestParam("id") Integer[] ids) throws Exception {
        Arrays.asList(ids).forEach(id -> departService.deleteDepartById(id));
        return Result.Success();
    }

    /**
	 * 新增部门管理
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated DepartDTO depart,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             departService.addDepart(depart);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新部门管理
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updateDepart(@Validated DepartDTO depart,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             departService.updateDepart(depart);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }
}
