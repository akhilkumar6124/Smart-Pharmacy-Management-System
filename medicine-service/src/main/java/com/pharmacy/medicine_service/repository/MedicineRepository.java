package com.pharmacy.medicine_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.medicine_service.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>{
    List<Medicine> findByNameIgnoreCase(String name);
}