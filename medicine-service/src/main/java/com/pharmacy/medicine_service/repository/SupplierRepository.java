package com.pharmacy.medicine_service.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.medicine_service.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}