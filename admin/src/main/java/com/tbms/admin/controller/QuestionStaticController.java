package com.tbms.admin.controller;

import com.google.gson.Gson;
import com.tbms.Module.PieViewResult;
import com.tbms.core.dto.AnwserDTO;
import com.tbms.core.dto.QuestionDTO;
import com.tbms.core.service.AnwserService;
import com.tbms.core.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question/static")
public class QuestionStaticController {
    @Resource
    AnwserService anwserService;
    @Resource
    QuestionService questionService;

    @GetMapping
    public String statistic(@RequestParam("question_id") Integer question_id) {
        // 根据question_type查找问题并确定问题类型
        Map<Object, Object> condition  =  new HashMap<>();
        condition.put("questionId", question_id);
        QuestionDTO question = questionService.getQuestionById(question_id);    // 获得问题的实体
        List<AnwserDTO> anwserList = anwserService.getAnwserList(condition);    // 获得答案的实体
        int question_type = question.getQuestionType();     // 获得答案类型
        int anwserTotle = anwserList.size();
        // 获得选项的List
        List<String> optionList = Arrays.asList(question.getQuestionOption().split(";"));

        if (question_type == 1) {  // 单选题的统计方式，使用流
            Map<String, Double> result  = new HashMap<>();
            for (String opt : optionList) { result.put(opt, 0.00); }    // 构造包含所有选项的map以便合并
            // 通过Stream获得现有问题的提交答案的统计
            Map<String, Double> anwserStatic = anwserList.stream()
                    .collect(Collectors.groupingBy(AnwserDTO::getSubmitOption,
                             Collectors.collectingAndThen(Collectors.counting(), e -> e/(double)anwserTotle*100)));
            result.putAll(anwserStatic);    // 将两个map合并，以防止有些选项没人选不可显示
            // 根据Highcharts所需要的数据格式返回相应的json
            List<PieViewResult> staResults = optionList.stream()
                    .map(opt -> new PieViewResult(opt, result.get(opt))).collect(Collectors.toList());
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", 0);
            jsonMap.put("question", question.getQuestionTitle());
            jsonMap.put("question_type", "单选题");
            jsonMap.put("totleSub", anwserTotle);
            jsonMap.put("data", staResults);
            Gson gson = new Gson();
            String jsonStr = gson.toJson(jsonMap);
            return jsonStr;
        } else if (question_type == 2) {
            Map<String, Integer> result = new HashMap<>();
            for (String opt : optionList) { result.put(opt, 0); }
            List<String> optionAll = new ArrayList<>();
            // 将答案中的多选选项分开并全部放入List中方便统计
            Iterator<AnwserDTO> anwserIter = anwserList.iterator();
            while (anwserIter.hasNext()) {
                optionAll.addAll(Arrays.asList(anwserIter.next().getSubmitOption().split(";")));
            }
            Map<String, Integer> anwserStatic = optionAll.stream()
                    .collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
            result.putAll(anwserStatic);    // 求并集，以免某些选项未被选中
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", 0);
            jsonMap.put("question", question.getQuestionTitle());
            jsonMap.put("question_type", "多选题");
            jsonMap.put("totle", anwserTotle);
            jsonMap.put("categories", result.keySet());
            jsonMap.put("data", result.values());
            Gson gson = new Gson();
            String jsonStr = gson.toJson(jsonMap);
            return jsonStr;
        } else if (question_type == 3) {
            Map<String, Long> result = new HashMap<>();
            for (String opt : optionList) { result.put(opt, 0L); }
            int totleGrade = 0;
            for (AnwserDTO anwser : anwserList) { totleGrade += Integer.parseInt(anwser.getSubmitOption()); }
            float avgGrade = 0f;
            if (anwserTotle != 0)   avgGrade = totleGrade / anwserTotle;
            Map<String, Long> anwserStatic = anwserList.stream()
                    .collect(Collectors.groupingBy(AnwserDTO::getSubmitOption,
                            Collectors.collectingAndThen(Collectors.counting(), e -> e)));
            result.putAll(anwserStatic);    // 求并集，以免某些选项未被选中
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", 0);
            jsonMap.put("question", question.getQuestionTitle());
            jsonMap.put("question_type", "评分题");
            jsonMap.put("totle", anwserTotle);
            jsonMap.put("avgGrade", avgGrade);
            jsonMap.put("categories", result.keySet());
            jsonMap.put("data", result.values());
            Gson gson = new Gson();
            String jsonStr = gson.toJson(jsonMap);
            return jsonStr;
        } else if (question_type == 4) {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", 0);
            Gson gson = new Gson();
            String jsonStr = gson.toJson(jsonMap);
            return jsonStr;
        } else {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", -1);
            Gson gson = new Gson();
            String jsonStr = gson.toJson(jsonMap);
            return jsonStr;
        }
    }

}
