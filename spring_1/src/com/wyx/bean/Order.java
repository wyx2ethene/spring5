package com.wyx.bean;

public class Order {
    private String oname;
    private String address;
    //建议有参构造

    public Order(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public String getOname() {
        return oname;
    }

    public String getAddress() {
        return address;
    }
}
