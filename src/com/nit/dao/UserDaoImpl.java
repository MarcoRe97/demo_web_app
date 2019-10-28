package com.nit.dao;

import com.nit.entity.User;
import com.nit.util.C3p0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private C3p0Util c3p0Util = new C3p0Util();
    @Override
    public boolean findUser(String userName, String userPwd) {
        String sql = "select user_name from tbuser where user_name='"+userName+"' and user_pwd='"+userPwd+"'";
        try {
            conn = c3p0Util.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                c3p0Util.close(conn,pst,rs,null,null);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean findUserWithUserName(User user) {
        String userName = user.getUserName();
        String sql = "select user_name from tbuser where user_name='"+userName+"'";
        try{
            conn = c3p0Util.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        c3p0Util.close(conn,pst,rs,null,null);
        return false;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into tbuser(user_name,user_pwd,user_phone) values(?,?,?)";
        try{
            conn = c3p0Util.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,user.getUserName());
            pst.setString(2,user.getUserPwd());
            pst.setString(3,user.getUserPhone());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入异常");
        }
        c3p0Util.close(conn,pst,rs,null,null);
    }
}
