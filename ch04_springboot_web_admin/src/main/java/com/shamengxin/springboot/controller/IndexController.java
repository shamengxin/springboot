package com.shamengxin.springboot.controller;

import com.shamengxin.springboot.bean.Account;
import com.shamengxin.springboot.bean.User;
import com.shamengxin.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;

    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Long id){

        return accountService.getAcctById(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb( ){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        return aLong.toString();
    }

    /**
     * 到登录页
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model) {

        /*Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            return "main";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }*/

        return "main";
    }

}
