package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.entity.Order;

public interface OrderService {
    Order createOrder(Order order);
    void payOrder(Integer orderId);
}
