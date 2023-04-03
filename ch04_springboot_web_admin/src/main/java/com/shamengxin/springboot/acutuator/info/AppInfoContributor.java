package com.shamengxin.springboot.acutuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AppInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("ms","你好")
                .withDetail("hello","shamengxin")
                .withDetails(Collections.singletonMap("world","666666"));

    }
}
