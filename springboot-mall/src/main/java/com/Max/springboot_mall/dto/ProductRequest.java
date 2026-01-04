package com.Max.springboot_mall.dto;

import com.Max.springboot_mall.constant.ProductCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {

    //productId，資料庫會自動生成，不需要前端傳過來，刪掉

    @NotBlank(message = "productName不得為空")
    private String productName;

    @NotNull(message = "category不得為空")
    private ProductCategory category;

    @NotBlank(message = "imageUrl不得為空")
    private String imageUrl;

    @NotNull(message = "price不得為空")
    @Min(value = 1, message = "price不得小於1")
    private Integer price;

    @NotNull(message = "stock不得為空")
    @Min(value = 1, message = "stock不得小於1")
    private Integer stock;

    //描述，在mySql設定上是允許為空的
    private String description;
    //最後兩個時間，創建和最後修改時間，讓SpringBoot程式設定，不需要前端傳，刪掉


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "productName='" + productName + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                '}';
    }
}
