package com.tbms.core.common.aspect;

import com.tbms.core.common.annotation.SystemLog;
import com.tbms.core.common.base.PageResultSet;
import com.tbms.core.common.base.Result;
import com.tbms.core.common.util.JsonUtil;
import com.tbms.core.common.util.WebUtil;
import com.tbms.core.dto.LogDTO;
import com.tbms.core.dto.UserDTO;
import com.tbms.core.service.LogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统日志切面
 */
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(systemLog)")
    public void systemLogPointcut(SystemLog systemLog) {
    }

    @Around("systemLogPointcut(systemLog)")
    public Object aroundMethod(ProceedingJoinPoint point, SystemLog systemLog) throws Throwable {
        long time = System.currentTimeMillis();
        try {
            Object returns = point.proceed();
            save(point, returns, systemLog, System.currentTimeMillis() - time);
            return returns;
        } catch (Throwable e) {
            save(point, e, systemLog, System.currentTimeMillis() - time);
            throw e;
        }
    }

    private void save(ProceedingJoinPoint point, Object returns, SystemLog systemLog, Long time) {
        String sign = point.getSignature().toString();

        // 获取相关参数
        WebUtil wu = WebUtil.getInstance();
        HttpServletRequest req = wu.getRequest();// 请求对象
        UserDTO user = (UserDTO) SecurityUtils.getSubject().getPrincipal();
        String qs = req.getQueryString();// 查询参数
        String url = req.getRequestURL().append(qs == null ? "" : "?" + qs).toString();// url
        String ip = wu.getIpAddress();// IP地址
        String method = req.getMethod();// 方法
        String protocol = req.getProtocol();// 协议
        String status = null;
        String msg = null;
        String desc = !StringUtils.isEmpty(systemLog.desc()) ? systemLog.desc() : systemLog.value();
        if (returns != null && returns instanceof Result) {
            Result result = (Result) returns;
            status = result.getCode();
            msg = result.getMsg();
        }

        if (returns != null && returns instanceof PageResultSet) {
            msg = "查询成功";
            status = HttpStatus.OK.toString();
        }

        String text = null;
        if (returns != null) {
            String tmp;
            if (returns instanceof CharSequence) {
                tmp = returns.toString();
            } else if (returns instanceof Throwable) {
                String m = ((Throwable) returns).getMessage();
                String n = returns.getClass().getSimpleName();
                tmp = m == null ? n : n + ": " + m;
            } else {
                tmp = JsonUtil.getInstance().obj2json(returns);
            }
            text = tmp;
        }

        // 构造入库参数
        LogDTO bean = new LogDTO();
        // 用户信息
        if (user != null) {
            bean.setUsername(user.getUsername());
        }
        // 请求信息
        bean.setIp(ip);
        bean.setMethod(method + " " + protocol);
        bean.setUri(url);
        // 执行信息
        bean.setExecMethod(sign);
        bean.setExecTime(time);
        // 请求参数
        if ("POST".equals(method)) {
            bean.setArgs(JsonUtil.getInstance().obj2json(point.getArgs()[0]));
        }
        bean.setStatus(msg);
        bean.setExecDesc(desc);
        // 响应信息
        bean.setReturnVal(text);
        // 入库
        logService.addLog(bean);

    }

}
