package com.cyx.springMVC._06_springMVC_modelAttribute;

import com.cyx.springMVC._05_springMVC_request_parameters.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelAttribute")
public class ModelAttributeController {

    /*
        ModelAttribute 注解：
            针对复合类型（非简单类型）参数，缺省情况下，形参会被放至 Model 中（共享），缺省的 key 为形参的类型且首字母小写。

            1、标注在形参上，给共享的复合类型参数起别名；
            2、标注在方法上：
                ①、标注在一个请求处理方法上，为返回的共享数据设置 key 名称（一般用于返回 JSON 数据）；
                ②、标注在一个非请求处理方法上，每次在请求处理方法之前都会优先被执行（存放多个请求需要共享的数据）。
    */

    // 默认情况下复合类型参数会被放置 Model 中用来共享数据，而共享数据的 key 为被放置的形参的类型，且首字母小写
    @RequestMapping("/testDefault")
    public String testDefault(User user) {
        return "/04_user/user";
    }

    // ModelAttribute 注解标注在形参上，为共享数据设置 key 名称
    @RequestMapping("/modelAttributeOnParameter")
    public String modelAttributeOnParameter(@ModelAttribute("u") User user) {
        return "/04_user/user";
    }

    // ModelAttribute 注解标注在一个非请求处理方法上
    @ModelAttribute
    public void doWork() {
        System.out.println("执行 doWork 方法···");
    }

}
