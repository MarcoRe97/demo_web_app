package com.nit.service;

import com.nit.dao.UserDao;
import com.nit.dao.UserDaoImpl;
import com.nit.entity.User;

public class UserServiceImpl implements UserService{
    public boolean judgeLogin(String userName,String userPwd){
        UserDao userDao = new UserDaoImpl();
        if(userDao.findUser(userName,userPwd)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean registerUser(User user) {
        UserDao userDao = new UserDaoImpl();
        if(!userDao.findUserWithUserName(user)){
            userDao.addUser(user);
            return true;
        }
        return false;
    }
}
