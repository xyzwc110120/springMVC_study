package com.cyx.springMVC._02_springMVC_by_annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 处理器
@Controller
public class HelloController {

    @RequestMapping("02_hello1")
    public ModelAndView sayHello() {
        System.out.println("基于注解的方式配饰 SpringMVC1");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/01_hello/welcome");
        mv.addObject("msg", "基于注解配置成功1");
        return mv;
    }

    @RequestMapping("02_hello2")
    public ModelAndView sayHello2() {
        System.out.println("基于注解的方式配饰 SpringMVC2");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/01_hello/welcome");
        mv.addObject("msg", "基于注解配置成功2");
        return mv;
    }

}
