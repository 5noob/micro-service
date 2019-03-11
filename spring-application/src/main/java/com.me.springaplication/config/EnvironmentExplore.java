package com.me.springaplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author OuyangJie
 * @Date 2019/2/24 17:10
 * @Description: springboot配置优先级探索
 */
@Component
public class EnvironmentExplore {

    @Value("${from}")
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
