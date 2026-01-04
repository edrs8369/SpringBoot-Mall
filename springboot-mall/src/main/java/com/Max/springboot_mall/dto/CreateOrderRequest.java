package com.Max.springboot_mall.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateOrderRequest {

    @NotEmpty(message = "購物清單不可為空")
    private List<BuyItem> buyItemList;

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "buyItemList=" + buyItemList +
                '}';
    }
}
