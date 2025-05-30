package com.example.fooddeliveryapp.fooddeliveryapp.service;

import com.example.fooddeliveryapp.fooddeliveryapp.model.User;
import com.example.fooddeliveryapp.fooddeliveryapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> findAll() {
        return userRepository.findAll();
    }

    Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    void save(User user) {
        userRepository.save(user);
    }

    void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
