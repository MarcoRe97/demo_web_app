package com.nit.entity;

public class Book {
    private int bookId;
    private String bookName;
    private double bookPrice;

    public Book() {
    }

    public Book(int id, String bookName, double bookPrice) {
        this.bookId = id;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public int getId() {
        return bookId;
    }

    public void setId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
