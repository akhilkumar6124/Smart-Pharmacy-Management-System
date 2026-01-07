package com.pharmacy.billing_service.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BillingJdbcRepository{
    @Autowired
    private JdbcTemplate template;
    
    public BigDecimal calculateTotal(Long prescriptedId){
        String sql = """
                SELECT SUM(m.price * pi.quantity)
                FROM prescription_items pi
                JOIN medicines m ON pi.medicine_id = m.id
                WHERE pi.prescription_id = ?
                """;
        return template.queryForObject(sql, BigDecimal.class, prescriptedId);
    }
}