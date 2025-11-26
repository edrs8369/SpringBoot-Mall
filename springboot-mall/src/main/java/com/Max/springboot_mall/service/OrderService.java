package com.Max.springboot_mall.service;

import com.Max.springboot_mall.dto.CreateOrderRequest;
import com.Max.springboot_mall.model.Order;
import jakarta.validation.Valid;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
