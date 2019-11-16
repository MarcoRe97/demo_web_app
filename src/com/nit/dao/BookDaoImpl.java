package com.nit.dao;

import com.nit.entity.Book;
import com.nit.util.C3p0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private C3p0Util c3p0Util = new C3p0Util();
    @Override
    public List<Book> findBook(String bookStr) {
        List<Book> bookList = new ArrayList<Book>();
        String sql = "select * from book where book_name like '%"+bookStr+"%' ";
        try{
            conn = c3p0Util.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setBookPrice(rs.getDouble(3));
                bookList.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<Book>();
        String sql = "select * from book ";
        try {
            conn = c3p0Util.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setBookPrice(rs.getDouble(3));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
