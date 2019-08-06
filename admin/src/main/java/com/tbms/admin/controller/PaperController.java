package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.PaperDTO;
import com.tbms.core.dto.UserDTO;
import com.tbms.core.service.PaperService;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.*;

import com.tbms.core.common.util.DateUtil;

/**
 * 类描述:     问卷表控制器
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:18
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/paper")
public class PaperController {
    @Resource
    private PaperService paperService;

    /**
     * 显示问卷表页面
    */
    @RequestMapping
    public String toPaper(){
            return "paper";
    }

    /**
	 * 查询问卷表列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<PaperDTO> list(Page page) throws Exception {
        return paperService.findByPage(page);
    }

    /**
	 * 根据id查询问卷表
	 */
    @RequestMapping("/{id}")
    public PaperDTO getPaperById(@PathVariable("id") Integer id) throws Exception {
        return paperService.getPaperById(id);
    }

    /**
	 * 根据id删除问卷表
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deletePaper(@RequestParam("id") Integer[] ids) throws Exception {
        Arrays.asList(ids).forEach(id -> paperService.deletePaperById(id));
        return Result.Success();
    }

    /**
	 * 新增问卷表
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated PaperDTO paper,BindingResult bindingResult) throws Exception{
	    String paper_type = paper.getPaperType();
        Map<Object, Object> condition = new HashMap<>();
        condition.put("status", 1);
        condition.put("paperType", paper_type);
	    List<PaperDTO> paperList = paperService.getPaperList(condition);
	    if (!paperList.isEmpty() && paper.getStatus() == 1) {
	        return Result.Failure("-2", "目前只能同时发布一张问卷");
        }
	    long startTime = DateUtil.dateToStamp(paper.getStartTime());
	    long endTime = DateUtil.dateToStamp(paper.getEndTime());
	    if (endTime <= startTime) {
	        return Result.Failure("-1", "请选择合适的结束时间！");
        }
        long createTime = new Date().getTime() / 1000;
        UserDTO userDTO = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        paper.setCreateTime(String.valueOf(createTime));
        paper.setStartTime(String.valueOf(startTime));
        paper.setEndTime(String.valueOf(endTime));
        paper.setUserId(userDTO.getId());
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             paperService.addPaper(paper);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新问卷表
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updatePaper(@Validated PaperDTO paper,BindingResult bindingResult) throws Exception {
        String paper_type = paper.getPaperType();
        Map<Object, Object> condition = new HashMap<>();
        condition.put("status", 1);
        condition.put("paperType", paper_type);
        List<PaperDTO> paperList = paperService.getPaperList(condition);

        if (!paperList.isEmpty() && paper.getStatus() == 1) {
            for (PaperDTO paperDTO : paperList) {
                if (paperDTO.getId() == paper.getId())
                    break;
                else
                    return Result.Failure("-2", "目前只能同时发布一张问卷");
            }
        }
        long startTime = DateUtil.dateToStamp(paper.getStartTime());
        long endTime = DateUtil.dateToStamp(paper.getEndTime());
        long createTime = DateUtil.dateToStamp(paper.getCreateTime());
        if (endTime <= startTime) {
            return Result.Failure("-1", "请选择合适的结束时间！");
        }
        paper.setCreateTime(String.valueOf(createTime));
        paper.setStartTime(String.valueOf(startTime));
        paper.setEndTime(String.valueOf(endTime));
         try{
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             paperService.updatePaper(paper);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }
}
