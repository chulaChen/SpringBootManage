package com.chenzhuo.controller;

import com.chenzhuo.controller.diffresume.FileUpLoadClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("/welcome")
    public ModelAndView hello() {
        System.out.println("hahhahahhah");
        return new ModelAndView("user/index");
    }

    @RequestMapping({"resume"})
    public String list(
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        new FileUpLoadClient("127.0.0.1",8080).sendFile("D:\\Downloads\\ideaIU-2017.3.5.exe");
        return "成功了";
    }
}
