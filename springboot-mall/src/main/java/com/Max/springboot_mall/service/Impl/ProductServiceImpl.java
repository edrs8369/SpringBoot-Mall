package com.Max.springboot_mall.service.Impl;

import com.Max.springboot_mall.dao.ProductDao;
import com.Max.springboot_mall.model.Product;
import com.Max.springboot_mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
