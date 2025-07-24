package com.buyAndSell.server.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.buyAndSell.server.entities.User;
import com.buyAndSell.server.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }
}
