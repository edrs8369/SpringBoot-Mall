package com.Max.springboot_mall.service.Impl;

import com.Max.springboot_mall.dao.UserDao;
import com.Max.springboot_mall.dto.UserLoginRequest;
import com.Max.springboot_mall.dto.UserRegisterRequest;
import com.Max.springboot_mall.model.User;
import com.Max.springboot_mall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        //檢查註冊的email是否重複
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if(user != null){
            //{}可用來放參數
            log.warn("該 email {} 已經被 {} 註冊", userRegisterRequest.getEmail(), "Judy");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

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
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //比較帳號是否一致
        if(user.getPassword().equals(userLoginRequest.getPassword())){
            return user;
        } else {
            log.warn("email {} 的密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
