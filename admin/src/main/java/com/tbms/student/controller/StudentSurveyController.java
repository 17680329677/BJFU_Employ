package com.tbms.student.controller;

import com.tbms.core.dto.AnwserDTO;
import com.tbms.core.dto.PaperDTO;
import com.tbms.core.dto.QuestionDTO;
import com.tbms.core.dto.StudentDTO;
import com.tbms.core.service.AnwserService;
import com.tbms.core.service.PaperService;
import com.tbms.core.service.QuestionService;
import com.tbms.core.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * 类描述:     学生端问卷控制器
 * 创建人:     dhz
 * 创建时间:   2019-03-05 21:45:19
 * 版本:       v1.0
 */

@Controller
@RequestMapping("/stu")
public class StudentSurveyController {
    @Resource
    QuestionService questionService;
    @Resource
    PaperService paperService;
    @Resource
    AnwserService anwserService;
    @Resource
    StudentService studentService;

    @RequestMapping("/survey")
    public String toSurvey(Model model) {
        List<QuestionDTO> questionList = new ArrayList<>();
        StudentDTO studentDTO = (StudentDTO) SecurityUtils.getSubject().getPrincipal();
        StudentDTO student = studentService.getStudentById(studentDTO.getId());
        if (student.getStatus() != -4){
            model.addAttribute("status", 0);
            return "student/surveyFinish";
        }
        try {
            Map<Object, Object> paperCondition = new HashMap<>();
            paperCondition.put("status", 1);
            paperCondition.put("paperType", "毕业生");
            List<PaperDTO> paperList = paperService.getPaperList(paperCondition);
            if (paperList.isEmpty() || paperList.size() > 1) {
                model.addAttribute("status", 1);
                return "student/surveyFinish";
            }
            Map<Object, Object> condition = new HashMap<>();
            condition.put("paperId", paperList.get(0).getId());
            condition.put("order", "asc");
            condition.put("sort", "question_type");
            questionList  = questionService.getQuestionList(condition);
            PaperDTO paper = paperService.getPaperById(paperList.get(0).getId());
            model.addAttribute("questionList", questionList);
            model.addAttribute("paper", paper);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            model.addAttribute("questionList", questionList);
        }
        return "student/survey";
    }

    @RequestMapping(value = "/survey_add",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String subAnswer(@RequestBody ArrayList<AnwserDTO> answerList) {
        StudentDTO studentDTO = (StudentDTO) SecurityUtils.getSubject().getPrincipal();
        long submitTime = new Date().getTime() / 1000;
        JSONObject result = new JSONObject();
        try {
            for (AnwserDTO anwser : answerList) {
                anwser.setStudentId(studentDTO.getId());
                anwser.setSubmitTime(String.valueOf(submitTime));
                anwserService.addAnwser(anwser);
            }
            // 提交后修改用户状态
            studentDTO.setStatus(0);
            studentDTO.setPassword(null);   // 防止密码被修改
            studentService.updateStudent(studentDTO);
            result.put("code", "200");
            result.put("msg", "提交成功");
            return result.toString();
        } catch (Exception e) {
            result.put("code", "-1");
            result.put("msg", e.getMessage());
            return result.toString();
        }
    }
}
