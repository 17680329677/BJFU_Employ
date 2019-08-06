package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.MajorDTO;
import com.tbms.core.service.MajorService;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述:     专业控制器
 * 创建人:     青枫
 * 创建时间:   2019-02-02 16:21:41
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/major")
public class MajorController {
    @Resource
    private MajorService majorService;

    /**
     * 显示专业页面
    */
    @RequestMapping
    public String toMajor(){
            return "major";
    }

    /**
	 * 查询专业列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<MajorDTO> list(Page page) throws Exception {
        return majorService.findByPage(page);
    }

    /**
	 * 根据id查询专业
	 */
    @RequestMapping("/{id}")
    public MajorDTO getMajorById(@PathVariable("id") Integer id) throws Exception {
        return majorService.getMajorById(id);
    }

    /**
     * 根据id查询专业
     */
    @ResponseBody
    @RequestMapping("/code/{code}")
    public List<MajorDTO> getMajorByCode(@PathVariable("code") String code) throws Exception {
        Map condition = new HashMap();
        condition.put("departCode",code);
        return majorService.getMajorList(condition);
    }

    /**
	 * 根据id删除专业
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteMajor(@RequestParam("id") Integer[] ids) throws Exception {
        Arrays.asList(ids).forEach(id -> majorService.deleteMajorById(id));
        return Result.Success();
    }

    /**
	 * 新增专业
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated MajorDTO major,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             majorService.addMajor(major);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新专业
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updateMajor(@Validated MajorDTO major,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             majorService.updateMajor(major);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }
}
