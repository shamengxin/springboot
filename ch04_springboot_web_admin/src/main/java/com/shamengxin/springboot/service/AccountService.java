package com.shamengxin.springboot.service;

import com.shamengxin.springboot.bean.Account;
import com.shamengxin.springboot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctById(Long id){
        return accountMapper.getAcct(id);
    }

}
