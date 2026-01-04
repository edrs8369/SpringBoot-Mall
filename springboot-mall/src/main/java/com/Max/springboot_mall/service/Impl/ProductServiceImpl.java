package com.Max.springboot_mall.service.Impl;

import com.Max.springboot_mall.dao.ProductDao;
import com.Max.springboot_mall.dto.ProductQueryParams;
import com.Max.springboot_mall.dto.ProductRequest;
import com.Max.springboot_mall.model.Product;
import com.Max.springboot_mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {

        Product product = productDao.getProductById(productId);
        checkProductExists(productId, product);
        return product;
    }


    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {

        Product product = productDao.getProductById(productId);
        checkProductExists(productId, product);
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        Product product = productDao.getProductById(productId);
        checkProductExists(productId, product);
        productDao.deleteProductById(productId);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {

        Set<String> allowedOrderBy = Set.of("created_date", "price", "product_name");
        if (!allowedOrderBy.contains(productQueryParams.getOrderBy())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "orderBy 不合法");
        }

        String sort = productQueryParams.getSort();

        //忽略大小寫
        if (!sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "sort 不合法");
        }


        return productDao.getProducts(productQueryParams);
    }

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        return productDao.countProduct(productQueryParams);
    }

    private static void checkProductExists(Integer productId, Product product) {
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "商品不存在: " + productId);
        }
    }
}
