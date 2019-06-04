package com.cyx.springMVC._04_springMVC_request_skip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 请求跳转处理
@Controller
@RequestMapping("/request/skip")
public class RequestSkipController {

    // 请求转发，转发后浏览器地址栏不变，共享之前请求中的数据
    @RequestMapping("/testForward")
    public String testForward() {
        // 原理：request.getRequestDispatcher("页面路径").forward(request, response);
        return "forward:/views/02_static/staticB.html";
    }

    // URL 重定向，重定向后浏览器地址栏变为重定向后的地址，不共享之前请求的数据
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        // 原理：response.sendRedirect("页面路径");
        return "redirect:/staticA.html";
    }

    /*
        资源请求路径问题：
            /02_static/staticB.html 和 02_static/staticB.html：
                访问资源的时候前面加上 “/”，表示绝对路径，从根路径开始去寻找资源。
                访问资源的时候前面不加 “/”，表示相对路径，从当前文件所在文件夹中开始去寻找资源。

            eg：
                redirect:/02_static/staticB.html --> localhost:8080/hello.html
                redirect:02_static/staticB.html --> localhost:8080/_04_springMVC_request_skip/hello.html
    */

    // URL 重定向共享资源
    @RequestMapping("/testRedirectModel")
    public String testRedirectModel(RedirectAttributes ra) {
        // 此方式共享数据会加在重定向 URL 后面作为参数传递
        ra.addAttribute("msg1", "共享数据 msg1");
        // 此方式不会将共享数据放在重定向 URL 后作为参数
        ra.addFlashAttribute("msg2", "共享数据 mgs2");
        return "redirect:/request/skip/testRedirectResult";
    }

    // 重定向目标地址
    @RequestMapping("/testRedirectResult")
    public ModelAndView testRedirectResult(String msg1, @ModelAttribute("msg2") String msg2) {
        System.out.println("重定向共享数据 msg1：" + msg1);
        System.out.println("重定向共享数据 msg2：" + msg2);
        return null;
    }

}
