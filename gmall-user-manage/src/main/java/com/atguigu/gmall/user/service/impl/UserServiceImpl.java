package com.atguigu.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UserAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.auguigu.gmall.bean.UserAddress;
import com.auguigu.gmall.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;


    @Override
    public List<UserInfo> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<UserAddress> findAddressByUserId(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(userId);
        List<UserAddress> addressList = userAddressMapper.select(userAddress);
        return addressList;
    }
}
