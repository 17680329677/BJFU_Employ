package com.tbms.admin.controller;

import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.ResourceDTO;
import com.tbms.core.service.ResourceService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类描述:     资源控制器
 * 创建人:     青枫
 * 创建时间:   2018-06-10 16:21:26
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Resource
    private ResourceService resourceService;

    @RequestMapping
    public String toResource(){
        return "resource";
    }

    /**
	 * 查询列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public List<ResourceDTO> list() throws Exception {
        return resourceService.getResourceList(null);
    }

    /**
	 * 根据id查询
	 */
    @RequestMapping("/{id}")
    public ResourceDTO getResourceById(@PathVariable("id") Integer id) throws Exception {
        return resourceService.getResourceById(id);
    }

    /**
	 * 根据id删除
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteResource(@RequestParam("id")Integer id) throws Exception {
        try {
            resourceService.deleteResourceById(id);
        } catch (Throwable throwable){
            return Result.Failure("0", "请检查数据");
        }
        return Result.Success();
    }

    /**
	 * 新增
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(ResourceDTO resource,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             resourceService.addResource(resource);
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
    public Result updateResource(@Validated ResourceDTO resource,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             resourceService.updateResource(resource);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }
}
