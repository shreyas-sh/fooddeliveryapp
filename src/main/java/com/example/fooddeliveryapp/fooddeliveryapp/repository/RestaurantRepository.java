package com.example.fooddeliveryapp.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.fooddeliveryapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}