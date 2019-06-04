package com.cyx.springMVC._11_springMVC_demo.interceptor;

import com.cyx.springMVC._11_springMVC_demo.utils.MemberContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 登陆检查拦截器（拦截器需要实现 org.springframework.web.servlet.HandlerInterceptor 接口）
public class CheckLoginInterceptor implements HandlerInterceptor {

    // 覆盖 preHandle 方法，进行拦截操作
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 若 session 中没有用户信息，则表示没有登陆
        if (MemberContext.getCurrentMember() == null) {
            // 重定向至登陆页面
            response.sendRedirect(request.getContextPath() + "/demo/login/toLogin");
            // 阻止放行
            return false;
        }
        // 放行
        return true;
    }
}
