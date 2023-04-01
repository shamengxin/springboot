package com.shamengxin.springboot.mapper;

import com.shamengxin.springboot.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    public Account getAcct(Long id);

}
