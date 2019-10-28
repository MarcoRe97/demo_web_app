package com.nit.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class C3p0Util {

    //    通过标识创建连接池
    static ComboPooledDataSource cpds = null;
    static {
        cpds = new ComboPooledDataSource("mysql");
    }


    //    获取连接对象
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = cpds.getConnection();
            System.out.println("获取连接成功");
            return conn;

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取连接失败");
            return null;
        }
    }
    //    关闭连接，释放资源
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs, Statement st, CallableStatement cstmt){
        if(conn != null){
            try {
                conn.close();

            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("关闭连接失败");
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(cstmt!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
