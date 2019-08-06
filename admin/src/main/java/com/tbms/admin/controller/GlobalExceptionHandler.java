package com.tbms.admin.controller;


import com.tbms.core.common.base.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody// 返回json数据
    public Result<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception	{
        return Result.Failure("500","访问错误");
    }
}
