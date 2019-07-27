package com.atguigu.gmall.service;

import com.auguigu.gmall.bean.UserAddress;
import com.auguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户信息
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 根据id查询用户地址信息
     * @param userId
     * @return
     */
    List<UserAddress> findAddressByUserId(String userId);

}
