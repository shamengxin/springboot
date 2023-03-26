package com.shamengxin.boot.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
