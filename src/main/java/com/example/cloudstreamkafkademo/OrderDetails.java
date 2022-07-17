package com.example.cloudstreamkafkademo;

class OrderDetails {
    private String orderid;

    public OrderDetails(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderid() {
        return orderid;
    }
}
