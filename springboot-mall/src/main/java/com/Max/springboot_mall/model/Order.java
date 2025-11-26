package com.Max.springboot_mall.model;

import javax.xml.crypto.Data;

public class Order {

    private Integer orderId;
    private Integer userId;
    private Integer totalAmount;
    private Data createdDate;
    private Data lastModifiedDate;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Data getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Data createdDate) {
        this.createdDate = createdDate;
    }

    public Data getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Data lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
