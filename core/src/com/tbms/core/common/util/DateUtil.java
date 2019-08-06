package com.tbms.core.common.util;

import com.tbms.core.dto.BasicDTO;
import com.tbms.core.service.BasicService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static long dateToStamp(String s) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime() / 1000;
        return ts;
    }

    public static Integer currentYear(BasicService basicService){
        Map condition = new HashMap();
        //查询当前年度
        condition.put("type","currentYear");
        List list = basicService.getBasicList(condition);
        if(list.size()>0){
            BasicDTO tmp = (BasicDTO)list.get(0);
            return Integer.parseInt(tmp.getCode());
        }
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
