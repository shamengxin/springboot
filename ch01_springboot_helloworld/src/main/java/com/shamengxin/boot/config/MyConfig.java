package com.shamengxin.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.shamengxin.boot.bean.Car;
import com.shamengxin.boot.bean.Pet;
import com.shamengxin.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
// @ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    @Bean
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom22")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }

}
