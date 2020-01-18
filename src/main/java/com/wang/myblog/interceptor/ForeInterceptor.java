package com.wang.myblog.interceptor;

import com.wang.myblog.entity.SysLog;
import com.wang.myblog.entity.SysView;
import com.wang.myblog.service.SysService;
import com.wang.myblog.util.BrowserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class ForeInterceptor implements HandlerInterceptor {
    @Autowired
    SysService sysService;
    private SysLog sysLog = new SysLog();
    private SysView sysView = new SysView();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String ip = request.getRemoteAddr();
        String url = request.getRequestURL().toString();
        String userbrowser = BrowserUtil.getOsAndBrowserInfo(request);

        sysLog.setIp(ip);
        sysLog.setOperateBy(StringUtils.isEmpty(ip) ? "0.0.0.0" : ip);
        sysLog.setOperateUrl(StringUtils.isEmpty(url) ? "获取url失败" : url);
        sysLog.setOperateBy(StringUtils.isEmpty(userbrowser) ? "获取浏览器名失败" : userbrowser);

        sysView.setIp(StringUtils.isEmpty(ip)?"0.0.0.0":ip);
        sysService.addView(sysView);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            sysLog.setRemark(method.getName());
            sysService.addLog(sysLog);
        }else{
            String uri = request.getRequestURI();
            sysLog.setRemark(uri);
            sysService.addLog(sysLog);
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

    }

}
