package com.Max.springboot_mall.rowmapper;

import com.Max.springboot_mall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer productId = rs.getInt("product_id");
        String productName = rs.getString("product_name");
        String category = rs.getString("category");
        String imageUrl = rs.getString("image_url");
        Integer price = rs.getInt("price");
        Integer stock = rs.getInt("stock");
        String description = rs.getString("description");
        Date createdDate = rs.getTimestamp("created_date");
        Date lastModifiedDate = rs.getTimestamp("last_modified_date");

        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setCategory(category);
        product.setImageUrl(imageUrl);
        product.setPrice(price);
        product.setStock(stock);
        product.setDescription(description);
        product.setCreatedDate(createdDate);
        product.setLastModifiedDate(lastModifiedDate);

        return product;
    }
}
