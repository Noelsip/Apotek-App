package com.tubes11.apotekerreal.model;

public class LoginPage {
    private String fullName;
    private String userId;
    private String password;

    public LoginPage(String fullName, String userId, String password) {
        this.fullName = fullName;
        this.userId = userId;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
