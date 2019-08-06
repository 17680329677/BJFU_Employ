package com.tbms.core.common.base;

import com.tbms.core.dto.UserDTO;
import org.apache.shiro.SecurityUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class PageCondition {

    /**
     * 分部门构造查询分页条件
     */
    public static Map util(Page page){
        Map<Object, Object> condition = addCondition(page);
        UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        //研究生院的管理员departCode为0,可以查看全部研究生信息，部门只能查看本部门的信息
        if(!user.getDepartCode().equals("0")){
            condition.put("departCode",user.getDepartCode());
        }
        return condition;
    }

    /**
     * 学生分页查询条件构造
     */
    public static Map util(Page page,String username){
        Map<Object, Object> condition = addCondition(page);
        if(!StringUtils.isEmpty(username)){
            condition.put("account",username);
        }
        return condition;
    }

    /**
     * page构造查询信息
     */
    public static Map addCondition(Page page){
        Map<Object, Object> condition = new HashMap<>();
        condition.put("offset", page.getOffset());
        condition.put("size", page.getLimit());
        if (!StringUtils.isEmpty(page.getSearch()) && !StringUtils.isEmpty(page.getScolumn())) {
            searchFilter(page,condition);
        }
        if (!StringUtils.isEmpty(page.getOrder().name())) {
            condition.put("order", page.getOrder().name());
        }
        if (!StringUtils.isEmpty(page.getSort())) {
            condition.put("sort", page.getSort());
        }
        return condition;
    }

    /**
     * 多字段搜索按逗号分隔
     */
    private static void searchFilter(Page page,Map condition){
        String[] column = page.getScolumn().split(",");
        String[] search = page.getSearch().split(",");
        if(column.length == search.length){
            for (int i = 0; i < column.length; i++) {
                condition.put(column[i],search[i]);
            }
        }else{
            condition.put("status",10);
        }
    }
}
