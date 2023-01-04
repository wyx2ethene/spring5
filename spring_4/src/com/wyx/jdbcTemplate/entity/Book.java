package com.wyx.jdbcTemplate.entity;

public class Book {
    private String userId;
    private String userName;
    private String userStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userStatus='" + userStatus + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

}
