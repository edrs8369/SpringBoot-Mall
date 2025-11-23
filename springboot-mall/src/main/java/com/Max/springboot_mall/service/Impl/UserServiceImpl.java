package com.Max.springboot_mall.service.Impl;

import com.Max.springboot_mall.dao.UserDao;
import com.Max.springboot_mall.dto.UserRegisterRequest;
import com.Max.springboot_mall.model.User;
import com.Max.springboot_mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
