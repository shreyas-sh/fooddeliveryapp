package com.example.fooddeliveryapp.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.fooddeliveryapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}