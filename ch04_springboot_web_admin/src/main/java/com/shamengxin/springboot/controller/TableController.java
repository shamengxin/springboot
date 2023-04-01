package com.shamengxin.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shamengxin.springboot.bean.User;
import com.shamengxin.springboot.exception.UserTooManyException;
import com.shamengxin.springboot.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){

        int i = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);


        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model,@RequestParam(value = "pn",defaultValue = "1")Integer pn){

        /*List<User> users = Arrays.asList(new User("zhangsan", "123456"),
                new User("aaa", "ccc"),
                new User("bbb", "aaa"),
                new User("ccc", "bbb"));
        model.addAttribute("users",users);

        if (users.size() > 3) {

            throw new UserTooManyException();
        }*/

        List<User> list = userService.list();

        // model.addAttribute("users",list);

        Page<User> userPage = new Page<>(pn, 2);
        Page<User> page = userService.page(userPage, null);

        model.addAttribute("page",page);

        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

}
