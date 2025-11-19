package com.Max.springboot_mall.service;

import com.Max.springboot_mall.dto.ProductRequest;
import com.Max.springboot_mall.model.Product;
import jakarta.validation.Valid;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
