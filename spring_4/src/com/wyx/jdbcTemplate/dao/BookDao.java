package com.wyx.jdbcTemplate.dao;

import com.wyx.jdbcTemplate.entity.Book;

import java.util.List;

public interface BookDao {
    public void add(Book book);

    public void update(Book book);

    public void delete(Book book);

    public int selectCount();

    public Book findInfo(String userId);

    public List<Book> findAllInfo();

    public void batchAdd(List<Object[]> args);

    public void batchUpdate(List<Object[]> args);

    public void batchDelete(List<Object[]> args);
}
