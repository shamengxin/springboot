package com.shamengxin.boot.bean;

import lombok.*;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private String name;
    private Integer age;

    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
