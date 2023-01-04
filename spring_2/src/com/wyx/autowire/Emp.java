package com.wyx.autowire;

public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void test() {
        System.out.println("test from Emp");
    }
}
