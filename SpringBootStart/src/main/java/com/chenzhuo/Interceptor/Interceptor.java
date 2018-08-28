package com.chenzhuo.Interceptor;

import com.chenzhuo.model.ConfigFile;
import com.chenzhuo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cz
 * @Date 2018/8/24
 * @Description
 */
@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    private ConfigFile configFile;
    @Autowired
    private Environment env ;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("能不能进来");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");

        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");

        httpServletResponse.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");

        httpServletResponse.setHeader("X-Powered-By","Jetty");


        String method= httpServletRequest.getMethod();
        String url = httpServletRequest.getRequestURI();
        String path = httpServletRequest.getContextPath();
//        if (method.equals("OPTIONS")){
//            httpServletResponse.setStatus(200);
//            return false;
//        }
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null){
            return true;
        }

//        String localurl =  env.getProperty("configInfo.localUrl");
//        httpServletResponse.sendRedirect(ConfUtil.getConf("LOCAL_URL")+"app/index");
        System.out.println(method);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
