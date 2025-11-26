package com.Max.springboot_mall.dao;

import com.Max.springboot_mall.model.Order;
import com.Max.springboot_mall.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId, int totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemById(Integer orderId);
}
