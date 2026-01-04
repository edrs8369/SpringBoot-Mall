package com.Max.springboot_mall.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRegisterRequest {

    //除了不能為null之外也不能為空字串
    //檢查是否為email格式
    @NotBlank(message = "email不得為空")
    @Email(message = "email格式不正確")
    private String email;

    @NotBlank(message = "密碼不得為空")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegisterRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
