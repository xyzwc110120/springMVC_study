package com.cyx.springMVC._03_springMVC_response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

// 处理响应
@Controller
@RequestMapping("/response")
public class HandleResponseController {

    // 返回 void 类型：此时就是把 Controller 方法当作 Servlet 来使用（不推荐）
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("msg", "返回 void 类型");
        // 请求转发
        request.getRequestDispatcher("/WEB-INF/views/03_response/result.jsp").forward(request, response);
    }

    // 返回 void 类型：文件下载（不推荐）
    @RequestMapping("/testVoidDownload")
    public void testVoidDownload(OutputStream out) throws IOException {
        Files.copy(Paths.get("F:/Img/535a27168fcf2524.jpg!200x200.jpg"), out);
    }

    // 返回 ModelAndView 类型
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/03_response/result");
        mv.addObject("msg", "返回 ModelAndView 类型");
        mv.addObject("没有设置 key");
        return mv;
    }

    // 返回 String 类型，返回的视图的 URL，此时需要结合 Model 类型的参数一起使用（共享数据）
    @RequestMapping("/testString")
    public String testString(Model model) {
        model.addAttribute("msg", "返回 String 类型");
        model.addAttribute("没有设置 key");
        return "/03_response/result";
    }

}
