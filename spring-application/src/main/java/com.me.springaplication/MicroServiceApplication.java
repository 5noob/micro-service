package com.me.springaplication;

import com.me.autoconfig.Cat;
import com.me.springaplication.importselector.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

@Import({MyImportSelector.class})
@ComponentScans({
        @ComponentScan("com.me.scantest")
})
@SpringBootApplication
public class MicroServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MicroServiceApplication.class, args);

        //验证@EnableAutoConfiguration Import的AutoConfigurationImportSelector.class的作用
        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);

        //验证@EnableAutoConfiguration Import的AutoConfigurationPackages.Registrar.class的作用
        Object autoConfigurationPackages = context.getBean(AutoConfigurationPackages.class.getName());
        System.out.println(autoConfigurationPackages);
    }

}

