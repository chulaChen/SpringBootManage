package com.chenzhuo.common;

import java.io.Serializable;

/**
 * @author cz
 * @Date 2018/8/24
 * @Description
 */
public class ServiceData implements Serializable {
    public static final int STATUS_ERROR = -1;

    public int status;// 状态 1 : success  0以下失败

    public String info;// msg 信息

    public Object data;// 业务数据

    public Object page;     //分页数据

    public ServiceData() {
        this.status = STATUS_ERROR;
        this.info = "fail";
        this.data = null;
    }

    public ServiceData(int status, String info, Object data) {
        this.status = status;
        this.info = info;
        this.data = data;
    }
    public ServiceData(int status, String info, Object data,Object page) {
        this.status = status;
        this.info = info;
        this.data = data;
        this.page = page;
    }
//    public String toJson() {
//        DBObject d = new BasicDBObject();
//        d.put("status", this.status);
//        d.put("info", this.info);
//        d.put("data", this.data);
//        return JSON.serialize(d);
//    }

    public void error(Exception e) {
        error(e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
    }

    public void error(String error) {
        this.info = error;
        this.status = STATUS_ERROR;
    }

    public void success(String success) {
        this.info = success;
        this.status = 1;
    }

    public void message(String error, String success) {
        if(error == null)
            success(success);
        else
            error(error);
    }
}
