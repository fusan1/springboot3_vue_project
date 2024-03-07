package com.example.springbootmybatis.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;

}
