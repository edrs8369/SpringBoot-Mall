package com.Max.springboot_mall.dao;

import com.Max.springboot_mall.dto.ProductRequest;
import com.Max.springboot_mall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
