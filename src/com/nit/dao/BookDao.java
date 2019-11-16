package com.nit.dao;

import com.nit.entity.Book;

import java.util.List;

public interface BookDao {
    public List<Book> findBook(String bookStr);
    public List<Book> findAllBooks();
}
