package com.nit.servlet;

import com.nit.entity.Book;
import com.nit.service.BookService;
import com.nit.service.BookServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;  charset=utf-8");
        List<Book> books = new ArrayList<>();
        BookService bookService = new BookServiceImpl();
        books = bookService.findAllBooks();
        PrintWriter out = response.getWriter();
        JSONArray bookList = JSONArray.fromObject(books);
        out.write(bookList.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
