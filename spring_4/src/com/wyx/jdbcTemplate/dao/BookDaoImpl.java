package com.wyx.jdbcTemplate.dao;

import com.wyx.jdbcTemplate.entity.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Book book) {
        //调用update方法实现添加操作
//        update(String sql, Object... args)
//        参数1. sql语句
//        参数2. 可变参数，填补sql语句中的?
//        String sql = "insert into t_book values(?,?,?)";
//        Object[] args = {book.getUserId(), book.getUserName(), book.getUserStatus()};
//        int update = jdbcTemplate.update(sql, args);
//        System.out.println(update);
    }

    @Override
    public void update(Book book) {
//        String sql = "update t_book set user_name = ?, user_status = ? where user_id = ?";
//        Object[] args = {book.getUserName(), book.getUserStatus(), book.getUserId()};
//        int update = jdbcTemplate.update(sql, args);
//        System.out.println(update);
    }

    @Override
    public void delete(Book book) {
        String sql = "delete from t_book where user_id = ?";
        Object[] args = {book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    /**
     * 该方法用于查找单条记录并返回一个Book对象，需要注意的是，当调用BeanPropertyRowMapper实现类时，Book类中必须有set方法，
     * 且类中属性名称最好与表格中的列名一致，或者类中属性名称满足驼峰命名法(e.g. userName)，不然输出的结果中会含有null
     *
     * @param userId
     * @return
     */
    public Book findInfo(String userId) {
        String sql = "select * from t_book where user_id = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), userId);
        return book;
    }

    @Override
    public List<Book> findAllInfo() {
        String sql = "select * from t_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void batchAdd(List<Object[]> args) {
        String sql = "insert into t_book values(?,?,?)";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(batchUpdate));
    }

    @Override
    public void batchUpdate(List<Object[]> args) {
        String sql = "update t_book set user_name = ?, user_status = ? where user_id = ?";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(batchUpdate));
    }

    @Override
    public void batchDelete(List<Object[]> args) {
        String sql = "delete from t_book where user_id = ?";
        System.out.println(Arrays.toString(jdbcTemplate.batchUpdate(sql, args)));
    }
}
