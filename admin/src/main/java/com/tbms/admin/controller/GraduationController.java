package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;

import com.tbms.core.common.util.DateUtil;
import com.tbms.core.dto.BasicDTO;
import com.tbms.core.dto.GraduationDTO;
import com.tbms.core.dto.UserDTO;
import com.tbms.core.service.BasicService;
import com.tbms.core.service.GraduationService;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述:     就业统计控制器
 * 创建人:     青枫
 * 创建时间:   2019-03-20 15:51:03
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/graduation")
public class GraduationController {
    @Resource
    private GraduationService graduationService;
    @Resource
    private BasicService basicService;

    /**
     * 显示就业统计页面
    */
    @RequestMapping
    public String toGraduation(Model model){
        Map condition = new HashMap();
        condition.put("status",1);
        //查询当前年度
        model.addAttribute("currentYear",DateUtil.currentYear(basicService));
        //查询就业类型
        condition.put("type","employ");
        model.addAttribute("employList",basicService.getBasicList(condition));
        return "graduation";
    }

    /**
	 * 查询就业统计列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<GraduationDTO> list(Page page) throws Exception {
        return graduationService.findByPage(page);
    }

    /**
     * 视图显示
     */
    @ResponseBody
    @RequestMapping("/show/{graduateYear}/{type}")
    public Result show(@PathVariable("graduateYear") Integer graduateYear,@PathVariable("type") Integer type) throws Exception {
        Map condition = new HashMap();
        UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        //毕业年度
        condition.put("year",graduateYear);
        //毕业生类型
        condition.put("type",type);

        //研究生院的管理员departCode为0,按学院查看统计图
        if(!user.getDepartCode().equals("0")){
            //部门按专业查看统计图
            condition.put("departCode",user.getDepartCode());
        }else{
            condition.put("major","合计");
        }
        List<GraduationDTO> list = graduationService.getGraduationList(condition);
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                GraduationDTO item = list.get(i);
                if(user.getDepartCode().equals("0")){
                    //移除全校汇总项
                    if("all".equals(item.getDepartCode())){
                        list.remove(i);
                    }
                }else{
                    if("合计".equals(item.getMajor())){
                        //移除专业汇总项
                        list.remove(i);
                    }
                }
            }
            return Result.Success(list);
        }
        return Result.Failure("0","没有相关数据");
    }

    /**
	 * 根据id删除就业统计
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteGraduation(@RequestParam("id") Integer[] ids) throws Exception {
        graduationService.deleteGraduationBatch(ids);
        return Result.Success();
    }

    /**
	 * 新增就业统计
	 */
    @ResponseBody
    @RequestMapping("/generate")
    public Result generate(String graduateYear) throws Exception {
        try {
            Map condition = new HashMap();
            condition.put("year",graduateYear);
            //从basic数据库查询就业状态数据
            Map basicMap = new HashMap();
            basicMap.put("type","employ");
            List<BasicDTO> basicList = basicService.getBasicList(basicMap);
            Map<String,Integer> map = new HashMap<>();
            //basic中employ数据的Describe描述的是Analyse中16个统计数据
            //分别取出code值，以map形式传，在mybatis中分别使用key和value
            for(BasicDTO basic:basicList){
                map.put(basic.getDescribe(),Integer.parseInt(basic.getCode()));
            }
            //最后一个按照学院统计时，以合计填充专业字段，以看出是合计
            condition.put("msg","合计");
            //查询学位层次代码,分别生成硕士和博士的统计数据
            basicMap.put("type","degree");
            basicMap.put("status",1);
            basicList = basicService.getBasicList(basicMap);
            int majorCount = 0;
            int departCount = 0;
            for (BasicDTO basic:basicList){
                condition.put("degreeCode",basic.getCode());
                majorCount = graduationService.insertMajorGraduation(condition,map);
                if(majorCount == 0){
                    return Result.Failure("0", "无专业统计数据生成");
                }
                departCount = graduationService.insertDepartGraduation(condition,map);
                if(departCount == 0){
                    return Result.Failure("0", "无学院统计数据生成");
                }
            }
        } catch (Throwable throwable){
            return Result.Failure("0", "生成统计数据失败");
        }
        return Result.Success();
    }
}
