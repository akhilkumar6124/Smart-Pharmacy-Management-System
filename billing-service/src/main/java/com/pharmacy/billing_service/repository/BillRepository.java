package com.pharmacy.billing_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.billing_service.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{

}