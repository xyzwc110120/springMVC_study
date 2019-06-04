package com.cyx.springMVC._09_springMVC_json;

import com.cyx.springMVC._05_springMVC_request_parameters.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class HandleJsonController {

    /*
        处理 JSON 的注解：
            @RespondBody：
                处理响应，把对象转化为 JSON 字符串：
                    标注在方法上：之针对当前方法做 JSON 处理；
                    标注在类上：会对当前类中所有的方法做 JSON 处理。

            @RestController：
                @RespondBody + @Controller。

            @RequestBody：
                处理请求，用于读取 HTTP 请求的内容，把 JSON　格式的请求数据封装成对象。
    */

    /*
        一般的请求数据格式：
            application/x-www-form-urlencoded：
                这应该是最常见的 POST 提交数据的方式了。浏览器的原生 <form> 表单，如果不设置 enctype 属性，
                那么最终就会以 application/x-www-form-urlencoded 方式提交数据。 传统的 key-value 格式，处理起来非常方便，
                不需要 @RequestBody 注解。

            multipart/form-data：
                我们使用表单上传文件时，必须让 <form> 表单的 enctype 等于 multipart/form-data，
                Spring MVC 对它做了一个装饰设计模式，让它既能处理文件上传，也能处理普通表单数据。

            application/json：
                参数是 JSON 格式的，此时必须使用 @RequestBody 注解。
    */

    // 把对象转换程 JSON 字符串返回
    @RequestMapping("/returnJson")
    @ResponseBody
    public User returnJson(User user) {
        return user;
    }

    // 将 JSON 格式的请求数据封装成的对象
    @RequestMapping("/getJson")
    public void getJson(@RequestBody User user) {
        System.out.println(user);
    }

}
