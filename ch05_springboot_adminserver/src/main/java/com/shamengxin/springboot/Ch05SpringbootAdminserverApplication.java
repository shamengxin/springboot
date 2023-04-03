package com.shamengxin.springboot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class Ch05SpringbootAdminserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch05SpringbootAdminserverApplication.class, args);
    }

}
