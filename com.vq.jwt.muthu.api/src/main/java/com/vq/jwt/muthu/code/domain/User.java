package com.vq.jwt.muthu.code.domain;

import org.springframework.data.annotation.Id;

public class User {

    private String userEmail;
    private  String password;


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }







}
