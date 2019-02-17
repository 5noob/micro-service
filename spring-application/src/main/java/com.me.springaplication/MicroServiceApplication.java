package com.me.springaplication;

import com.me.autoconfig.Cat;
import com.me.springaplication.importselector.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@Import({MyImportSelector.class})
@ComponentScans({
        @ComponentScan(basePackages = "com.me.scantest", excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class)
        })
})
@SpringBootApplication
public class MicroServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MicroServiceApplication.class, args);

        //1、验证@EnableAutoConfiguration Import的AutoConfigurationImportSelector.class的作用
        /**
         * 需要在spring.factories文件中加入org.springframework.boot.autoconfigure.EnableAutoConfiguration=@Configuration标记的类的路径
         */
        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);
        //不需要在spring.factories文件加路径，因为SamePackageExample的包路径和启动类的包路径相同
        SamePackageExample samePackageExample = context.getBean(SamePackageExample.class);
        System.out.println(samePackageExample);

        //2、验证@EnableAutoConfiguration Import的AutoConfigurationPackages.Registrar.class的作用
        Object autoConfigurationPackages = context.getBean(AutoConfigurationPackages.class.getName());
        System.out.println(autoConfigurationPackages);

        //3、验证启动类，是否注入了spring的bean池中
        MicroServiceApplication microServiceApplication = context.getBean(MicroServiceApplication.class);
        System.out.println(microServiceApplication);
    }

}

