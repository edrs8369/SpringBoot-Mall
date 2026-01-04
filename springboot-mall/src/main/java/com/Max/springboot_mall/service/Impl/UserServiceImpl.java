package com.Max.springboot_mall.service.Impl;

import com.Max.springboot_mall.dao.UserDao;
import com.Max.springboot_mall.dto.UserLoginRequest;
import com.Max.springboot_mall.dto.UserRegisterRequest;
import com.Max.springboot_mall.model.User;
import com.Max.springboot_mall.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        //檢查註冊的email是否重複
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if(user != null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "該 email: "+ userRegisterRequest.getEmail() + " 已經被註冊");
        }

        //使用MD5 生成密碼雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);

        //創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        //檢查帳號是否註冊
        if(user == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                              "該 email: " + userLoginRequest.getEmail() + "尚未註冊");
        }

        //使用MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        //比較密碼是否一致
        if(user.getPassword().equals(hashedPassword)){
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                              "email: " + userLoginRequest.getEmail() + " 的密碼不正確");
        }
    }
}
