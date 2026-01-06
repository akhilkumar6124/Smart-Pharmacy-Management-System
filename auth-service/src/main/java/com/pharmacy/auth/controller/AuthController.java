package com.pharmacy.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.auth.service.AuthService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pharmacy.auth.entity.User;


@RestController
@RequestMapping("/api/auth")
public class AuthController{
    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> postMethodName(@RequestBody Map<String, String> request) {
        User user = service.authenticate(request.get("username"), request.get("password"));
        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials...");
        }
        return ResponseEntity.ok(user);
    }
}