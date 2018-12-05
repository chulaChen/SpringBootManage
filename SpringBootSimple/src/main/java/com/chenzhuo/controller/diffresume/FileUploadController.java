package com.chenzhuo.controller.diffresume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cz
 * @Date 2018/12/5
 * @Description
 */
@Controller
@RequestMapping({"api/app"})
public class FileUploadController {

    @RequestMapping({"resume"})
    public String list(
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        new FileUpLoadClient("127.0.0.1",8080).sendFile("D:\\Downloads\\ideaIU-2017.3.5.exe");
        return "成功了";
    }
}
