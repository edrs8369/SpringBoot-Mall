package com.Max.springboot_mall.controller;

import com.Max.springboot_mall.model.Product;
import com.Max.springboot_mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {

        Product product = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else{
            //.build() 代表 不返回任何 body
            //也就是 HTTP 回應只有狀態碼，沒有內容
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
