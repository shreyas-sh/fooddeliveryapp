package com.example.fooddeliveryapp.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.fooddeliveryapp.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
