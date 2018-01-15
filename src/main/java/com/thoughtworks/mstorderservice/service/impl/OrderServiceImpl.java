package com.thoughtworks.mstorderservice.service.impl;

import com.thoughtworks.mstorderservice.Repository.OrderRepository;
import com.thoughtworks.mstorderservice.entity.Order;
import com.thoughtworks.mstorderservice.enums.OrderStatus;
import com.thoughtworks.mstorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public void payOrder(Integer orderId) {
        orderRepository.updateOrderStatus(orderId, OrderStatus.FINISHED.value());
    }

}
