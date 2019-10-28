package com.nit.servlet;

import com.nit.entity.User;
import com.nit.service.UserService;
import com.nit.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;  charset=utf-8");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("username");
        String userPwd = request.getParameter("password");
        String userPhone = request.getParameter("phone");
        User user = new User();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        user.setUserPhone(userPhone);
        UserService userService = new UserServiceImpl();
        if (userService.registerUser(user)){
            out.write("success");
        }
        else{
            out.write("error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
