package com.chenzhuo.controller;

import com.chenzhuo.common.CommonUtil;
import com.chenzhuo.common.ServiceData;
import com.chenzhuo.model.User;
import com.chenzhuo.service.UserService;
import com.chenzhuo.service.impl.UserServiceImpl;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        User user = userService.findUserName("admin","");
        System.out.println(user.getUserName());
        return new ModelAndView("user/welcome");
    }

    @RequestMapping("/login")
    @ResponseBody
    public ServiceData login(@RequestParam(value = "userName", required = false, defaultValue = "") String userName,
                             @RequestParam(value = "password", required = false, defaultValue = "") String password,
                             HttpServletRequest req, ModelMap data)throws Exception {
        ServiceData sd = new ServiceData();
        if(StringUtils.isEmpty(userName)){
            return sd;
        }
        if(StringUtils.isEmpty(password)){
            return sd;
        }
        String pwd = CommonUtil.EncoderByMd5(password);
        User user = userService.findUserName(userName,pwd);
        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            System.out.println(user.getUserName());
            sd.data = user;
            sd.status = 1;
            sd.info = "登录成功";
            return sd;
        }else{
            return sd;
        }

    }
    @RequestMapping(value = {"/","/index"})
    public ModelAndView index(Map<String, Object> model){
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.html
        model.put("time", new Date());
//        model.put("message", this.hello);
        return new ModelAndView("index");
    }
}
