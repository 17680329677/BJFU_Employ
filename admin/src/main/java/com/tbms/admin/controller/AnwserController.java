package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.AnwserDTO;
import com.tbms.core.service.AnwserService;

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
 * 类描述:     答案信息控制器
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:18
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/anwser")
public class AnwserController {
    @Resource
    private AnwserService anwserService;

    /**
     * 显示答案信息页面
    */
    @RequestMapping
    public String toAnwser(){
            return "anwser";
    }

    /**
	 * 查询答案信息列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<AnwserDTO> list(Page page) throws Exception {
        return anwserService.findByPage(page);
    }

    /**
	 * 根据id查询答案信息
	 */
    @RequestMapping("/{id}")
    public AnwserDTO getAnwserById(@PathVariable("id") Integer id) throws Exception {
        return anwserService.getAnwserById(id);
    }

    /**
	 * 根据id删除答案信息
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteAnwser(@RequestParam("id") Integer[] ids) throws Exception {
        Arrays.asList(ids).forEach(id -> anwserService.deleteAnwserById(id));
        return Result.Success();
    }

    /**
	 * 新增答案信息
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated AnwserDTO anwser,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             anwserService.addAnwser(anwser);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新答案信息
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updateAnwser(@Validated AnwserDTO anwser,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             anwserService.updateAnwser(anwser);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }
}
