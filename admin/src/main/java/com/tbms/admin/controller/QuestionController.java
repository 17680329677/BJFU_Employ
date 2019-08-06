package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.base.ResultCodeEnum;

import com.tbms.core.dto.PaperDTO;
import com.tbms.core.dto.QuestionDTO;
import com.tbms.core.service.PaperService;
import com.tbms.core.service.QuestionService;

import com.tbms.core.common.util.DateUtil;
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
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

import java.util.Date;

/**
 * 类描述:     问题信息控制器
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:19
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;
    @Resource
    private PaperService paperService;

    /**
     * 显示问题信息页面
    */
    @RequestMapping
    public String toQuestion(HttpServletRequest request, Model model){
        int id = Integer.valueOf(request.getParameter("id"));
        PaperDTO paperDTO = paperService.getPaperById(id);
        model.addAttribute("paper", paperDTO);
        return "question";
    }

    /**
     * 查询问题信息列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public PageResultSet<QuestionDTO> list(Page page) throws Exception {
        return questionService.findByPage(page);
    }

    /**
     * 根据问卷ID查询问题
     */
    @ResponseBody
    @RequestMapping("/list/{id}")
    public PageResultSet<QuestionDTO> list(@PathVariable("id") Integer id, Page page) {
        return questionService.findByPageAndPaper(page, id);
    }

    /**
	 * 根据id查询问题信息
	 */
    @RequestMapping("/{id}")
    public QuestionDTO getQuestionById(@PathVariable("id") Integer id) throws Exception {
        return questionService.getQuestionById(id);
    }

    /**
	 * 根据id删除问题信息
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteQuestion(@RequestParam("id") Integer[] ids) throws Exception {
        Arrays.asList(ids).forEach(id -> questionService.deleteQuestionById(id));
        return Result.Success();
    }

    /**
	 * 新增问题信息
	 */
	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@Validated QuestionDTO question,BindingResult bindingResult) throws Exception{
        long createTime = new Date().getTime() / 1000;
        question.setCreateTime(String.valueOf(createTime));
	    System.out.println(question);
         try {
             if (bindingResult.hasErrors()) {
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             questionService.addQuestion(question);
         } catch (Throwable throwable){
             return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }

    /**
	 * 更新问题信息
	 */
	@ResponseBody
    @RequestMapping("/update")
    public Result updateQuestion(@Validated QuestionDTO question,BindingResult bindingResult) throws Exception {
         try{
             long createTime = DateUtil.dateToStamp(question.getCreateTime());
             question.setCreateTime(String.valueOf(createTime));
             if (bindingResult.hasErrors()){
                 return Result.Failure(ResultCodeEnum.FieldError);
             }
             questionService.updateQuestion(question);
         }catch (Throwable throwable){
                return Result.Failure("0", "请检查数据");
         }
         return Result.Success();
    }
}
