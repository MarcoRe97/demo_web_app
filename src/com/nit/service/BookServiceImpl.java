package com.nit.service;

import com.nit.dao.BookDao;
import com.nit.dao.BookDaoImpl;
import com.nit.entity.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAllBooks();
    }
}
