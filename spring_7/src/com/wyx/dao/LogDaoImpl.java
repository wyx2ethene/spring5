package com.wyx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogDaoImpl implements LogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addLog(String id, String status) {
        String sql = "insert into log values(?,?)";
        Object[] args = {id, status};
        jdbcTemplate.update(sql, args);
    }
}
