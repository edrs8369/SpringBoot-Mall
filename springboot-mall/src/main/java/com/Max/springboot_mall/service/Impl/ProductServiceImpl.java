package com.Max.springboot_mall.service.Impl;

import com.Max.springboot_mall.constant.ProductCategory;
import com.Max.springboot_mall.dao.ProductDao;
import com.Max.springboot_mall.dto.ProductQueryParams;
import com.Max.springboot_mall.dto.ProductRequest;
import com.Max.springboot_mall.model.Product;
import com.Max.springboot_mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        return productDao.getProducts(productQueryParams);
    }
}
