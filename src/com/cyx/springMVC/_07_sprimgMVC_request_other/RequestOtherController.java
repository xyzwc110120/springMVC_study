package com.cyx.springMVC._07_sprimgMVC_request_other;

import com.cyx.springMVC._05_springMVC_request_parameters.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request/other")
@SessionAttributes("user")
public class RequestOtherController {

    /*
        获取请求中的信息：
            @RequestHeader 注解：获取请求头中的信息；
            @CookieValue 注解：获取指定的 cookie 信息
    */
    @RequestMapping("/getRequestMessage")
    public void getHeaderMessage(
            @RequestHeader("User-Agent") String userAgent,
            @CookieValue("JSESSIONID") String sessionId) {
        System.out.println(userAgent);
        System.out.println(sessionId);
    }

    /*
        操作 HttpSession：
            默认情况下，数据模型（Model）是保存到 request 作用域的，如果使用 URL 重定向跳转视图，request 中的数据是不能共享的。
            此时，我们就需要将 Model 保存到 Session 中，这样就可以在重定向后依然能共享数据：
                @SessionAttribute 注解：绑定在参数上，获取 Session 中指定属性，如果没有设置 value 属性值，则默认按照形参名称查找。
                @SessionAttributes 注解：绑定在类上，将指定的 Model 数据保存到 Session 中。
    */
    @RequestMapping("/sessionAttributes")
    public String sessionAttributes(User user) {
        return "redirect:/request/other/sessionAttribute";
    }

    @RequestMapping("/sessionAttribute")
    public String sessionAttribute(@SessionAttribute User user) {
        System.out.println(user);
        return "/04_user/user";
    }

}
