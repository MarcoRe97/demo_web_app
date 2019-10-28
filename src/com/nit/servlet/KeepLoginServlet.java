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

@WebServlet(name = "KeepLoginServlet")
public class KeepLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;  charset=utf-8");
        UserService userService = new UserServiceImpl();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if(session.getAttribute("userName") == null){
            out.write("error");
        }
        else{
            String userName = session.getAttribute("userName").toString();
            String userPwd = session.getAttribute("userPwd").toString();
            if(userService.judgeLogin(userName,userPwd)){
                out.write(userName);
            }
            else{
                out.write("error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
