package com.pharmacy.billing_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.billing_service.entity.Bill;
import com.pharmacy.billing_service.repository.BillRepository;
import com.pharmacy.billing_service.repository.BillingJdbcRepository;

@Service
public class BillingService{
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillingJdbcRepository jdbcRepository;

    public Bill generateBill(Long prescriptionId){
        BigDecimal total = jdbcRepository.calculateTotal(prescriptionId);
        Bill bill = new Bill();
        bill.setPrescriptionId(prescriptionId);
        bill.setTotalAmount(total);
        bill.setBillingDate(LocalDateTime.now());
        return billRepository.save(bill);
    }
}