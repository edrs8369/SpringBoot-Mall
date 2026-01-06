package com.Max.springboot_mall.dto;

public class LoginInfo {

    private Integer id;
    private String email;
    private String jwt;

    public LoginInfo() {
    }

    public LoginInfo(Integer id, String email, String jwt) {
        this.id = id;
        this.email = email;
        this.jwt = jwt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
