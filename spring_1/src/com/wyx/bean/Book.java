package com.wyx.bean;

public class Book {
    private String bname;
    private String bauthor;
    //创建对应的set方法

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBname() {
        return bname;
    }

    public String getBauthor() {
        return bauthor;
    }
}
