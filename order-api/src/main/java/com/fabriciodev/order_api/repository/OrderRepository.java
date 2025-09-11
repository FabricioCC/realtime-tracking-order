package com.fabriciodev.order_api.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.fabriciodev.order_api.model.Order;

@Repository
public interface OrderRepository extends ListCrudRepository<Order, Long> {
    
}
