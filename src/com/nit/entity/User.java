package com.nit.entity;

public class User {
    private String userName;
    private String userPwd;
    private String userPhone;
    private int id;

    public User() {
    }

    public User(String userName, String userPwd, String userPhone, int id) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", id=" + id +
                '}';
    }
}
