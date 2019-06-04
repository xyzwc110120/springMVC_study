package com.cyx.springMVC._13_springMVC_download;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/download")
public class DownloadController {

    @RequestMapping("/toDownload")
    public String toDownload() {
        return "/08_download/download";
    }

    // 使用 Servlet 方式
    @RequestMapping("/downloadByServlet")
    public void downloadByServlet(HttpServletResponse response) throws IOException {
        String dir = "F:/Img";
        String fileName = "123.jpg";
        // 设置响应头：下载文件
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 设置文件建议保存名称
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        Files.copy(Paths.get(dir, fileName), response.getOutputStream());
    }

    // 使用 Spring MVC 方式
    @RequestMapping("/downloadByMVC")
    public ResponseEntity<byte[]> downloadByMVC() throws IOException {
        String dir = "F:/Img";
        String fileName = "123.jpg";

        HttpHeaders headers = new HttpHeaders();
        // 设置响应头
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 设置文件建议保存名称
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity<>(
                FileUtils.readFileToByteArray(new File(dir, fileName)), headers, HttpStatus.CREATED);
    }

}
