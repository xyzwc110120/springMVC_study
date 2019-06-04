package com.cyx.springMVC._12_springMVC_upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
/*
    @MultipartConfig 注解：
        文件上传配置。

        location 属性：要将已上传的文件保存到磁盘中的位置。
        maxFileSize 属性：上传文件的最大容量，缺省值为 -1 表示没有限制，大于指定值会被拒绝。
        maxRequestSize 属性：表示一次请求允许最大容量，缺省值为 -1，表示没有限制。
        fileSizeThreshold 属性：上传文件超过该容量界限，会被写入到磁盘。
*/
@MultipartConfig(location = "F:/Img", maxFileSize = -1, fileSizeThreshold = 102400)
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/toForm")
    public String toForm() {
        return "/07_upload/upload";
    }

    @RequestMapping("/file")
    public void uploadFile(String name, Integer age, MultipartFile file) throws IOException {
        System.out.println(name);
        System.out.println(age);
        String fileName = file.getOriginalFilename();
        String saveDir = "F:/img";
        Files.copy(file.getInputStream(), Paths.get(saveDir, fileName));
    }
}
