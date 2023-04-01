package com.shamengxin.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.shamengxin")
@MapperScan("com.shamengxin.springboot.mapper")
public class Ch04SpringbootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch04SpringbootWebAdminApplication.class, args);
    }

}
