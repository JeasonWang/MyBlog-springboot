package com.wang.myblog.interceptor;

import com.wang.myblog.entity.User;
import com.wang.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台拦截器
 * 说明：对/admin开头的地址进行拦截，必须经过验证之后才能够访问
 *
 * @author:wang
 * @create:2018-06-20-下午 18:47
 */
public class BackInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        System.out.println("进入成功！");
        User user = (User) request.getSession().getAttribute("user");
        if (null == user) {
            flag = false;
        } else {
            // 对用户账号进行验证,是否正确
            User user1 = userService.getUser(user);
            if (user1 != null) {
                System.out.println("访问后台API");
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }
}
