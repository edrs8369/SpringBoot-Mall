package com.Max.springboot_mall.dao;

import com.Max.springboot_mall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

}
