package com.nit.dao;

import com.nit.entity.User;

public interface UserDao {
    public boolean findUser(String userName,String userPwd);
    public boolean findUserWithUserName(User user);
    public void addUser(User user);
}
