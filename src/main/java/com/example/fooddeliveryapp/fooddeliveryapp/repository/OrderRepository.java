package com.example.fooddeliveryapp.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.fooddeliveryapp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
