package com.atguigu.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.service.UserService;
import com.auguigu.gmall.bean.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    //@Autowired
    @Reference
    private UserService userService;

    @GetMapping("/getAddressById")
    public List<UserAddress> getAddressById(String userId){
        List<UserAddress> addressList = userService.findAddressByUserId(userId);
        return addressList;
    }
}
