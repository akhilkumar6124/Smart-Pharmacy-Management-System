package com.pharmacy.billing_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.billing_service.entity.Bill;
import com.pharmacy.billing_service.service.BillingService;

@RestController
@RequestMapping("/api/bills")
public class BillingController{
    @Autowired
    private BillingService service;
    
    @PostMapping("/{prescriptionId}")
    public Bill generate(@PathVariable Long prescriptionId){
        return service.generateBill(prescriptionId);
    }
}