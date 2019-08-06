package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.BasicDTO;
import com.tbms.core.service.BasicService;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述:     基础信息控制器
 * 创建人:     青枫
 * 创建时间:   2019-02-02 08:42:58
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/basic")
public class BasicController {
    @Resource
    private BasicService basicService;

    /**
     * 显示基础信息页面
     */
    @RequestMapping
    public String toBasic(Model model){
        model.addAttribute("typeList",basicService.getBasicTypeList());
        return "basic";
    }

    /**
	 * 查询基础信息列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<BasicDTO> list(Page page) throws Exception {
        return basicService.findByPage(page);
    }

    /**
     * 查询基础信息type列表
     */
    @ResponseBody
    @RequestMapping("/type")
    public List<BasicDTO> getType() throws Exception {
        return basicService.getBasicTypeList();
    }

    /**
     * 查询基础信息code列表
     */
    @ResponseBody
    @RequestMapping("/code/{type}")
    public List<BasicDTO> getCode(@PathVariable("type") String type) throws Exception {
        Map condition = new HashMap();
        if(type != null){
            condition.put("type",type);
        }
        return basicService.getBasicList(condition);
    }

    /**
	 * 根据id查询基础信息
	 */
    @RequestMapping("/{id}")
    public BasicDTO getBasicById(@PathVariable("id") Integer id) throws Exception {
        return basicService.getBasicById(id);
    }

    /**
	 * 根据id删除基础信息
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteBasic(@RequestParam("id") Integer[] ids) throws Exception {
        Arrays.asList(ids).forEach(id -> basicService.deleteBasicById(id));
        return Result.Success();
    }

    /**
	 * 新增基础信息
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated BasicDTO basic,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             basicService.addBasic(basic);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新基础信息
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updateBasic(@Validated BasicDTO basic,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             basicService.updateBasic(basic);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

}
