package com.Max.springboot_mall.service;

import com.Max.springboot_mall.dto.UserRegisterRequest;
import com.Max.springboot_mall.model.User;
import jakarta.validation.Valid;

public interface UserService {


    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
