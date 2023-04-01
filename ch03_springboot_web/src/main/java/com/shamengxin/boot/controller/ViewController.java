package com.shamengxin.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/smx")
    public String atSMX(Model model){

        model.addAttribute("msg","你好，smx");
        model.addAttribute("link","http://www.baidu.com");

        return "success";
    }

}
