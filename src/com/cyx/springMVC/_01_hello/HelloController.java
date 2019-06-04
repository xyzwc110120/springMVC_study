package com.cyx.springMVC._01_hello;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 处理器，实现 org.springframework.web.servlet.mvc.Controller 接口
public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("hello···");
        // 将后台返回的数据传递给 View 层，同时包含一个要访问的 View 层的 URL 地址
        ModelAndView modelAndView = new ModelAndView();
        // 设置视图名称（资源路径）
        modelAndView.setViewName("/01_hello/welcome");
        // 设置共享数据
        modelAndView.addObject("msg", "Hello World!!!");
        return modelAndView;
    }
}
