package com.nit.service;

import com.nit.entity.User;

public interface UserService {
    public boolean judgeLogin(String userName,String userPwd);
    public boolean registerUser(User user);
}
