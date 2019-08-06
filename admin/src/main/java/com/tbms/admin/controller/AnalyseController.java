package com.tbms.admin.controller;

import com.tbms.core.common.base.Page;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;

import com.tbms.core.common.util.DateUtil;
import com.tbms.core.common.util.ExcelUtil;
import com.tbms.core.dto.AnalyseDTO;
import com.tbms.core.dto.BasicDTO;
import com.tbms.core.dto.UserDTO;
import com.tbms.core.service.AnalyseService;

import com.tbms.core.service.BasicService;
import com.tbms.core.service.DepartService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述:     周报统计控制器
 * 创建人:     青枫
 * 创建时间:   2019-03-06 19:21:49
 * 版本:       v1.0
 */
@Controller
@RequestMapping("/analyse")
public class AnalyseController {
    @Resource
    private AnalyseService analyseService;
    @Resource
    private BasicService basicService;
    @Resource
    private DepartService departService;

    /**
     * 显示就业统计页面
    */
    @RequestMapping
    public String toAnalyse(Model model){
        Map condition = new HashMap();
        condition.put("status",1);
        //查询就业类型
        condition.put("type","employ");
        model.addAttribute("employList",basicService.getBasicList(condition));
        model.addAttribute("departList",departService.getDepartList(null));
        //查询当前年度
        model.addAttribute("currentYear",DateUtil.currentYear(basicService));
        return "analyse";
    }

    /**
	 * 查询就业统计列表
	 */
	@ResponseBody
    @RequestMapping("/list")
    public PageResultSet<AnalyseDTO> list(Page page) throws Exception {
        return analyseService.findByPage(page);
    }

    /**
     * 视图显示
     */
    @ResponseBody
    @RequestMapping("/show/{time}/{type}")
    public Result show(@PathVariable("time") String time, @PathVariable("type") Integer type) throws Exception {
        Map condition = new HashMap();
        UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        //生成时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        condition.put("createTime",sdf.parse(time));
        //毕业生类型
        condition.put("type",type);

        //研究生院的管理员departCode为0,按学院查看统计图
        if(!user.getDepartCode().equals("0")){
            //部门按专业查看统计图
            condition.put("departCode",user.getDepartCode());
        }else{
            condition.put("major","合计");
        }
        List<AnalyseDTO> list = analyseService.getAnalyseList(condition);
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                AnalyseDTO item = list.get(i);
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
     * 视图显示
     */
    @ResponseBody
    @RequestMapping("/showLine/{type}/{code}/{stu}")
    public Result showLine(@PathVariable("type") String type, @PathVariable("code") String code,@PathVariable("stu") String stu) throws Exception{
        Map condition = new HashMap();
        condition.put("type",stu);//硕士 博士
        if("depart".equals(type)){
            condition.put("departCode",code);
            condition.put("major","合计");
        }else{
            condition.put("majorCode",code);
        }
        List<AnalyseDTO> list = analyseService.getAnalyseList(condition);
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                AnalyseDTO item = list.get(i);
                    //移除全校汇总项
                if("all".equals(item.getDepartCode())){
                    list.remove(i);
                }
                if("major".equals(type)){
                    if("合计".equals(item.getMajor())){
                        //移除专业汇总项
                        list.remove(i);
                    }
                }
            }
        }
        return Result.Success(list);
    }
    /**
	 * 根据id删除就业统计
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public Result deleteAnalyse(@RequestParam("id") Integer[] ids) throws Exception {
        analyseService.deleteAnalyseBatch(ids);
        return Result.Success();
    }

    /**
     * 根据id生成周报统计
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
                majorCount = analyseService.insertMajorWeekAnalyse(condition,map);
                departCount = analyseService.insertDepartWeekAnalyse(condition,map);
                if(majorCount == 0){
                    return Result.Failure("0", "无专业统计数据生成");
                }
                if(departCount == 0){
                    return Result.Failure("0", "无学院统计数据生成");
                }
            }
        } catch (Throwable throwable){
            return Result.Failure("0", "生成统计数据失败");
        }
        return Result.Success();
    }

    /**
     * 下载数据
     */
    @RequestMapping("/download/{startTime}")
    public void export(@PathVariable("startTime") String startTime,HttpServletResponse response) throws Exception{
        UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        Map condition = new HashMap();
        //设置开始和结束时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        condition.put("createTime",sdf.parse(startTime));

        condition.put("sort","depart_code");
        condition.put("order","ASC");

        List<AnalyseDTO> list = analyseService.getAnalyseList(condition);
        String title;
        String head = user.getDepartName();
        if(list.size()>0){
            title = head+startTime+"日就业状态信息";
        }else{
            title = "本时间暂时没有就业状态统计数据";
        }
        ExcelUtil.exportExcel(list,title,head,AnalyseDTO.class,title+".xls",response);
    }
}
