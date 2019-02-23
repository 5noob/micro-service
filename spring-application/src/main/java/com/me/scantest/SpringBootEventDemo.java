package com.me.scantest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author OuyangJie
 * @Date 2019/2/19 20:18
 * @Description:
 */
@EnableAutoConfiguration
public class SpringBootEventDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEventDemo.class)
                .listeners(event -> {
                    System.err.println("监听到事件：" + event.getClass().getSimpleName());
                })
                .run(args)
                .close();
    }
}
