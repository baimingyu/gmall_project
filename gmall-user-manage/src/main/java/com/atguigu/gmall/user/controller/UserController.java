package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.service.UserService;
import com.auguigu.gmall.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<UserInfo> findAll(){
       return userService.findAll();
    }
}
