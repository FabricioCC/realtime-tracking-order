package com.fabriciodev.order_api.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fabriciodev.order_api.enums.OrderStatus;
import com.fabriciodev.order_api.model.Order;
import com.fabriciodev.order_api.model.User;
import com.fabriciodev.order_api.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    
    public Order createOrder(Long userId, BigDecimal total) {
        Order order = new Order();
        order.setUser(null);
        order.setTotal(total);
        order.setStatus(OrderStatus.CREATED);
        
        return orderRepository.save(order);
    }

      public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> updateStatus(Long id, OrderStatus newStatus) {
        return orderRepository.findById(id).map(order -> {
            order.setStatus(newStatus);
            return orderRepository.save(order);
        });
    }

}
