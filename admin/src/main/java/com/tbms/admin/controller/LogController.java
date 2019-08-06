package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.LogDTO;
import com.tbms.core.service.LogService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * 类描述:     日志控制器
 * 创建人:     青枫
 * 创建时间:   2018-08-05 08:58:06
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Resource
    private LogService logService;

    @RequestMapping
    public String toPage(Model model) {
        return "log";
    }

    /**
	 * 查询列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<LogDTO> list(Page page) throws Exception {
        return logService.findByPage(page);
    }

    /**
	 * 根据id查询
	 */
    @RequestMapping("/{id}")
    public LogDTO getLogById(@PathVariable("id") Integer id) throws Exception {
        return logService.getLogById(id);
    }

    /**
	 * 根据id删除
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteLog(@RequestParam("id") Integer[] ids) throws Exception {
        Arrays.asList(ids).forEach(id -> logService.deleteLogById(id));
        return Result.Success();
    }

    /**
	 * 新增
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated LogDTO log,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             logService.addLog(log);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updateLog(@Validated LogDTO log,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             logService.updateLog(log);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }
}
