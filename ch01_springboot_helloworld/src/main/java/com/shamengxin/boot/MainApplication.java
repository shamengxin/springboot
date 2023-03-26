package com.shamengxin.boot;

import com.shamengxin.boot.bean.Pet;
import com.shamengxin.boot.bean.User;
import com.shamengxin.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * 这是一个springboot应用
 */
// @SpringBootApplication(scanBasePackages = "com.shamengxin")
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan("com.shamengxin.boot")
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println("======"+beanNamesForType.length);

        //从容器中获取组件
        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("======"+beanNamesForType1.length);

       /* Pet tom01 = run.getBean("tom", Pet.class);

        Pet tom02 = run.getBean("tom", Pet.class);

        System.out.println("组件:"+(tom01==tom02));

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        User user01 = bean.user01();
        User user02 = bean.user01();
        System.out.println(user01==user02);

        User user03 = run.getBean("user01", User.class);
        Pet tom03 = run.getBean("tom", Pet.class);

        System.out.println("用户的宠物："+(user03.getPet() == tom03));

        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("===========");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }*/

        boolean tom = run.containsBean("tom");
        System.out.println("容器中Tom组件："+tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件："+user01);

        boolean tom22 = run.containsBean("tom22");
        System.out.println("容器中Tom组件："+tom22);

        boolean haha = run.containsBean("haha");
        System.out.println("haha："+haha);

        boolean hehe = run.containsBean("hehe");
        System.out.println("hehe："+hehe);
    }

}
