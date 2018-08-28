package com.chenzhuo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author cz
 * @Date 2018/8/28
 * @Description
 */
@Component
@ConfigurationProperties(prefix = "configInfo")
@PropertySource( "classpath:config.properties")
public class ConfigFile {

    private String localUrl;

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }
}
