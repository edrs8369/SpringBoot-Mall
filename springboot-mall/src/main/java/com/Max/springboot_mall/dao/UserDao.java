package com.Max.springboot_mall.dao;

import com.Max.springboot_mall.dto.UserRegisterRequest;
import com.Max.springboot_mall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(UserRegisterRequest userRegisterRequest);
}
