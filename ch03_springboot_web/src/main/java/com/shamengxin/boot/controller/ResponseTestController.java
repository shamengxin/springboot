package com.shamengxin.boot.controller;

import com.shamengxin.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setUserName("zhansan");
        person.setAge(15);
        person.setBirth(new Date());
        return person;
    }

}
