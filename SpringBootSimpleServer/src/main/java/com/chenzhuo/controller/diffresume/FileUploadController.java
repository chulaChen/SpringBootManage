package com.chenzhuo.controller.diffresume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cz
 * @Date 2018/12/5
 * @Description
 */
@RestController
@RequestMapping({"api/app"})
public class FileUploadController {

    @RequestMapping({"resume"})
    public String list(
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        new FileUpLoadClient("192.168.0.99",8080).sendFile("D:\\Downloads\\ideaIU-2017.3.5.exe");
        return "成功了";
    }
}
