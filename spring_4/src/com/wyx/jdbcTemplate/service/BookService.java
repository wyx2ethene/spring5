package com.wyx.jdbcTemplate.service;

import com.wyx.jdbcTemplate.entity.Book;
import com.wyx.jdbcTemplate.dao.BookDao;

import java.util.List;

public class BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public void updateBook(Book book) {
        bookDao.update(book);
    }

    public void delete(Book book) {
        bookDao.delete(book);
    }

    public int selectCount() {
        return bookDao.selectCount();
    }

    public Book findBookInfo(String userId) {
        return bookDao.findInfo(userId);
    }

    public List<Book> findAllBookInfo() {
        return bookDao.findAllInfo();
    }

    public void batchAddBook(List<Object[]> args) {
        bookDao.batchAdd(args);
    }

    public void batchUpdateBook(List<Object[]> args) {
        bookDao.batchUpdate(args);
    }

    public void batchDeleteBook(List<Object[]> args) {
        bookDao.batchDelete(args);
    }
}
