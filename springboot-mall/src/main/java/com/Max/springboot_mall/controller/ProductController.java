package com.Max.springboot_mall.controller;

import com.Max.springboot_mall.constant.ProductCategory;
import com.Max.springboot_mall.dto.ProductQueryParams;
import com.Max.springboot_mall.dto.ProductRequest;
import com.Max.springboot_mall.model.Product;
import com.Max.springboot_mall.service.ProductService;
import com.Max.springboot_mall.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(@Valid ProductQueryParams productQueryParams){

        log.info("條件分頁查詢: {}", productQueryParams);

        //取得product list
        List<Product> productList = productService.getProducts(productQueryParams);

        //取得product總數
        Integer total = productService.countProduct(productQueryParams);

        //分頁
        Page<Product> page= new Page<>();
        page.setLimit(productQueryParams.getLimit());
        page.setOffset(productQueryParams.getOffset());
        page.setTotal(total);
        page.setResult(productList);

        return  ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {

        log.info("查詢商品: productId = {}", productId);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){

        log.info("創建商品: {}", productRequest);

        //創建商品在sql上，並返回productId供查詢數據
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        //把 product 物件轉成 JSON 放在回應的正文裡。
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody ProductRequest productRequest){

        log.info("更新商品: {}", productRequest);

        //修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updateProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){

        log.info("刪除商品: {}", productId);

        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
