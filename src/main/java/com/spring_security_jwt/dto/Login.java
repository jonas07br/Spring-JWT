package com.spring_security_jwt.dto;

public class Login {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUserName(String userName) {
        this.username = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
