package com.cyx.springMVC._08_springMVC_request_objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

// 处理多对象传参
@Controller
@RequestMapping("/request/objects")
public class RequestObjectsController {

    // 跳转表单页面
    @RequestMapping("/toObjects")
    public String toObjects() {
        return "/05_objects/objects";
    }

    // 获取多对象参数，并且多对象中具有相同属性
    @RequestMapping("/objects")
    public void objects(Dog dog, Cat cat) {
        System.out.println(dog);
        System.out.println(cat);
    }

    /*
        为对象数据设置绑定规则：
            @InitBinder 注解：
                支持自定义绑定注册，用于将请求参数转换到对应的对象的属性中去。
                由 @InitBinder 注解标注的方法，可以对 WebDataBinder 对象进行初始化。
            而 WebDataBinder 是 DataBinder 的子类，用于完成请求参数到 JavaBean 的属性绑定。
                @InitBinder 注解的方法不能有返回值，它必须声明为 void。
    */

    // 把以 dog. 开头的参数封装到 Dog 对象中
    @InitBinder("dog")
    private void bindDog(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("dog.");
    }

    // 把以 cat. 开头的参数封装到 Cat 对象中
    @InitBinder("cat")
    private void bindCat(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("cat.");
    }
}
