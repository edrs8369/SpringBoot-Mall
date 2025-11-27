package com.Max.springboot_mall.rowmapper;

import com.Max.springboot_mall.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {

        int orderId = rs.getInt("order_id");
        int userId = rs.getInt("user_id");
        int totalAmount = rs.getInt("total_amount");
        Date createdDate = rs.getTimestamp("created_date");
        Date lastModifiedDate = rs.getTimestamp("last_modified_date");

        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        order.setCreatedDate(createdDate);
        order.setLastModifiedDate(lastModifiedDate);

        return order;
    }
}
