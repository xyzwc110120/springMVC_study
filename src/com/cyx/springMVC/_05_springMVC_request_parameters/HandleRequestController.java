package com.cyx.springMVC._05_springMVC_request_parameters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

// 处理请求参数
@Controller
@RequestMapping("/request/parameters")
public class HandleRequestController {

    // 使用 Servlet API 对象获取请求参数
    @RequestMapping("/servletAPI")
    public void servletAPI(HttpServletRequest request) {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("age"));
    }

    /*
        获取简单类型请求参数：
            如果请求参数和 Controller 方法的形式参数（入参）同名，可以直接接收。
            如果请求参数和 Controller 方法的形参不同名，则使用 @RequestParam 注解为参数起别名：
                name 属性：与 value 属性一样，为参数起别名；
                required 属性：参数是否必须，默认为 true；
                defaultValue 属性：设置参数的默认值。
    */
    @RequestMapping("/simpleType")
    public void simpleType(
            @RequestParam("name") String username,
            @RequestParam(value = "age", required = false) Integer age) {
        System.out.println(username);
        System.out.println(age);
    }

    /*
        RESTful 风格传参：
            在 @RequestMapping 注解的 URL 中使用 {参数名} 占位符的方式传参。
            然后通过 @PathVariable 注解将 URL 中占位符参数绑定到控制器处理方法的形参中。
    */
    @RequestMapping("/{name}")
    public void testRESTful(@PathVariable("name") String name) {
        System.out.println(name);
    }

    /*
        一个参数有多个参数值：
            使用数组：可以直接接收。
            使用 List 集合：不能直接接收，需要封装至 JavaBean 中参才能接收。
    */
    @RequestMapping("/batchParameters")
    public void batchParameters(Long[] ids) {
        System.out.println(Arrays.toString(ids));
    }

    /*
        JavaBean 类型请求参数：
            能够自动把请求参数封装到 Controller 方法的 JavaBean 类型的形参对象中，但是参数名必须与对象的属性名相同。
                http://localhost:8080/springMVC_study/request/parameters/javaBean?ids=1&ids=2&name=sdag
    */
    @RequestMapping("/javaBean")
    public void javaBean(User user) {
        System.out.println(user);
    }

}