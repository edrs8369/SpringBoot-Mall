package com.Max.springboot_mall.service.Impl;

import com.Max.springboot_mall.dao.OrderDao;
import com.Max.springboot_mall.dao.ProductDao;
import com.Max.springboot_mall.dao.UserDao;
import com.Max.springboot_mall.dto.BuyItem;
import com.Max.springboot_mall.dto.CreateOrderRequest;
import com.Max.springboot_mall.dto.OrderQueryParams;
import com.Max.springboot_mall.model.Order;
import com.Max.springboot_mall.model.OrderItem;
import com.Max.springboot_mall.model.Product;
import com.Max.springboot_mall.model.User;
import com.Max.springboot_mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        //檢查userId是否存在
        User user = userDao.getUserById(userId);

        if(user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND
                    , "該 userId " + userId + " 不存在");
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            // 檢查product是否存在，庫存是否足夠
            if(product == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND
                        , "商品 " + buyItem.getProductId() + " 不存在");
            } else if(product.getStock() < buyItem.getQuantity()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "商品 " + product.getProductId() + " 庫存數量不足，無法購買。" +
                                "剩餘庫存 " + product.getStock() + " " +
                                "，欲購買數量 " + buyItem.getQuantity());
            }

            // 扣除商品庫存
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());

//            if (product == null) {
//                throw new RuntimeException("商品不存在，productId=" + buyItem.getProductId());
//            }

            //計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(product.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        //創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {

        //分別取得兩張表中的數據
        Order order = orderDao.getOrderById(orderId);

        if (order == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "訂單不存在: " + orderId);
        }

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Override
    public List<Order> getOrders(OrderQueryParams orderQueryParams) {

        List<Order> orderList = orderDao.getOrders(orderQueryParams);
        for (Order order : orderList) {
            List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(order.getOrderId());

            order.setOrderItemList(orderItemList);
        }


        return orderList;
    }

    @Override
    public Integer countOrder(OrderQueryParams orderQueryParams) {
        return orderDao.countOrder(orderQueryParams);
    }
}
