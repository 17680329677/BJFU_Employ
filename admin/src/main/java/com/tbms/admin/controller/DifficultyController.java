package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.common.util.DateUtil;
import com.tbms.core.common.util.ExcelUtil;
import com.tbms.core.dto.DifficultyDTO;
import com.tbms.core.service.BasicService;
import com.tbms.core.service.DifficultyService;

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
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述:     困难学生信息控制器
 * 创建人:     青枫
 * 创建时间:   2019-03-20 15:24:10
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/difficulty")
public class DifficultyController {
    @Resource
    private DifficultyService difficultyService;
    @Resource
    private BasicService basicService;
    /**
     * 显示困难学生信息页面
    */
    @RequestMapping
    public String toDifficulty(Model model){
        Map condition = new HashMap();
        condition.put("status",1);
        //查询困难类型
        condition.put("type","difficult");
        model.addAttribute("difficultList",basicService.getBasicList(condition));
        //查询当前年度
        model.addAttribute("currentYear",DateUtil.currentYear(basicService));

        return "difficulty";
    }

    /**
	 * 查询困难学生信息列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<DifficultyDTO> list(Page page) throws Exception {
        return difficultyService.findByPage(page);
    }

    /**
     * 查询困难学生信息视图显示
     */
    @ResponseBody
    @RequestMapping("/show/{graduateYear}/{code}")
    public Result show(@PathVariable("graduateYear") Integer graduateYear,@PathVariable("code") Integer code) throws Exception {
        Map condition = new HashMap();
        condition.put("graduateYear",graduateYear);
        if(code != 0){
            condition.put("code",code);
        }
        List<DifficultyDTO> list = difficultyService.getDifficultyListView(condition);
        if(list.size()>0){
            return Result.Success(list);
        }
        return Result.Failure("0","没有相关数据");
    }


    /**
	 * 根据id查询困难学生信息
	 */
    @RequestMapping("/{id}")
    public DifficultyDTO getDifficultyById(@PathVariable("id") Integer id) throws Exception {
        return difficultyService.getDifficultyById(id);
    }

    /**
	 * 根据id删除困难学生信息
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteDifficulty(@RequestParam("id") Integer[] ids) throws Exception {
        difficultyService.deleteDifficultyBatch(ids);
        return Result.Success();
    }

    /**
	 * 新增困难学生信息
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated DifficultyDTO difficulty,BindingResult bindingResult) throws Exception{
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             difficultyService.addDifficulty(difficulty);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新困难学生信息
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updateDifficulty(@Validated DifficultyDTO difficulty,BindingResult bindingResult) throws Exception {
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             difficultyService.updateDifficulty(difficulty);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
     * 下载数据
     */
    @RequestMapping("/download/{graduateYear}")
    public void export(@PathVariable("graduateYear") Integer graduateYear,HttpServletResponse response) throws Exception{
        Map condition = new HashMap();
        condition.put("graduateYear",graduateYear);
        List<DifficultyDTO> list = difficultyService.getDifficultyList(condition);
        String title;
        if(list.size()>0){
            title = graduateYear+"年度困难学生信息";
        }else{
            title = "本年度暂时没有困难学生信息";
        }
        ExcelUtil.exportExcel(list,title,title,DifficultyDTO.class,title+".xls",response);
    }
}
