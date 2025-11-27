package com.Max.springboot_mall.service;

import com.Max.springboot_mall.dto.CreateOrderRequest;
import com.Max.springboot_mall.dto.OrderQueryParams;
import com.Max.springboot_mall.model.Order;
import jakarta.validation.Valid;

import java.util.List;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}
