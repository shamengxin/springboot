package com.shamengxin.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shamengxin.springboot.bean.User;
import com.shamengxin.springboot.mapper.UserMapper;
import com.shamengxin.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



}
