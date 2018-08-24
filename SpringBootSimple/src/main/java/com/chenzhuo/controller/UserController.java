package com.chenzhuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("/welcome")
    public ModelAndView hello() {
        System.out.println("hahhahahhah");
        return new ModelAndView("user/index");
    }
}
