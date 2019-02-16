package com.me.springaplication;

import com.me.autoconfig.Cat;
import com.me.springaplication.importselector.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@Import({MyImportSelector.class})
@SpringBootApplication
public class MicroServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MicroServiceApplication.class, args);

        //验证@EnableAutoConfiguration Import的AutoConfigurationImportSelector.class的作用
        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);

    }

}

