package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.Service.UserService;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.auguigu.gmall.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> findAll() {
        return userMapper.selectAll();
    }
}
