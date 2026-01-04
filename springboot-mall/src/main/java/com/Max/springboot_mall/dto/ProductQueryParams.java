package com.Max.springboot_mall.dto;

import com.Max.springboot_mall.constant.ProductCategory;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class ProductQueryParams {

    private ProductCategory category;
    private String search;
    private String orderBy = "created_date"; //default = created_date
    private String sort = "desc"; //default = desc

    @Max(value = 1000, message = "limit不可大於1000")
    @Min(value = 1, message = "limit不可小於1")
    private Integer limit = 5; //default = 5

    @Min(value = 0, message = "offset不可小於0")
    private Integer offset = 0; //default = 0


    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "ProductQueryParams{" +
                "category=" + category +
                ", search='" + search + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", sort='" + sort + '\'' +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
