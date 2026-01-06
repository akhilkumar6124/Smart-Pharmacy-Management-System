package com.pharmacy.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.auth.entity.User;
import com.pharmacy.auth.repository.UserRepository;

@Service
public class AuthService{
    @Autowired
    private UserRepository repo;

    public User authenticate(String username, String password){
        return repo.findByUsername(username).filter(u -> u.getPassword().equals(password)).orElse(null);
    }
}