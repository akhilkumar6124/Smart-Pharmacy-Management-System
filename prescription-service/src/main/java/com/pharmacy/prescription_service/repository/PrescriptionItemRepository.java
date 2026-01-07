package com.pharmacy.prescription_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.prescription_service.entity.PrescriptionItem;

@Repository
public interface PrescriptionItemRepository extends JpaRepository<PrescriptionItem, Long>{
    List<PrescriptionItem> findByPrescriptionId(Long prescriptionId);
}