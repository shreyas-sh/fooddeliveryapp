package com.example.fooddeliveryapp.fooddeliveryapp.service;

import com.example.fooddeliveryapp.fooddeliveryapp.model.Orders;
import com.example.fooddeliveryapp.fooddeliveryapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    List<Orders> findAll() {
        return orderRepository.findAll();
    }

    Optional<Orders> findById(Long id) {
        return orderRepository.findById(id);
    }

    void save(Orders order) {
        orderRepository.save(order);
    }

    void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
