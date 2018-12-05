package com.chenzhuo.controller.diffresume;

import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author cz
 * @Date 2018/12/5
 * @Description
 */
@Service
public class SocketServerListener extends HttpServlet {

    private static final long serialVersionUID = -999999999999999999L;

    //  初始化启动Socket服务
    @Override
    public void init() throws ServletException {
        super.init();
        for(int i = 0; i < 3; i++){
            if ("instart".equals(FinalVariables.IS_START_SERVER )) {
                open();
                break;
            }
        }
    }

    public void open(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @SuppressWarnings("resource")
            @Override
            public void run() {
                try {
                    FileUpLoadServer fileUpLoadServer = new FileUpLoadServer(FinalVariables.SERVER_PORT);
                    fileUpLoadServer.load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 3000);
    }
}
