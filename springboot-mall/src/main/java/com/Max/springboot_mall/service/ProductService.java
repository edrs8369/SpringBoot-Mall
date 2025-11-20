package com.Max.springboot_mall.service;

import com.Max.springboot_mall.constant.ProductCategory;
import com.Max.springboot_mall.dto.ProductQueryParams;
import com.Max.springboot_mall.dto.ProductRequest;
import com.Max.springboot_mall.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);
}
