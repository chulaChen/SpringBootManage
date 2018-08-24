package com.chenzhuo.controller;

import com.chenzhuo.common.ServiceData;
import com.chenzhuo.model.User;
import com.chenzhuo.service.UserService;
import com.chenzhuo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService ;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hahhahahhah");
        return "user/index";
    }

    @RequestMapping("/welcome")
    public ModelAndView  welcome() {
        System.out.println("hahhahahhah");
        User user = userService.findUserName("admin");
        System.out.println(user.getUserName());
        return new ModelAndView("user/welcome");
    }

    @RequestMapping("/login")
    @ResponseBody
    public ServiceData login() {
        ServiceData sd = new ServiceData();
        User user = userService.findUserName("admin");
        System.out.println(user.getUserName());
        sd.data = user;
        sd.status = 1;
        return sd;
    }
    @RequestMapping(value = {"/","/index"})
    public String index(Map<String, Object> model){
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.html
        model.put("time", new Date());
//        model.put("message", this.hello);
        return "/WEB-INF/jsp/index.html";
    }
}
