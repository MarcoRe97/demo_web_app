package com.nit.servlet;

import com.nit.service.UserService;
import com.nit.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;  charset=utf-8");
        HttpSession session = request.getSession();
        //        用于向前端输出结果
        PrintWriter out = response.getWriter();
        //      获取前端输入的账号和密码
        String account = request.getParameter("account");
        String secret = request.getParameter("secret");

        session.setAttribute("userName",account);
        session.setAttribute("userPwd",secret);
        UserService userService = new UserServiceImpl();
        if(userService.judgeLogin(account,secret)){
            out.write(account);
        }
        else{
            out.write("error");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
