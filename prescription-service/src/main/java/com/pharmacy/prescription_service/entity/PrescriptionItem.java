package com.pharmacy.prescription_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="prescription_items")
@Getter
@Setter
public class PrescriptionItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "prescription_id")
    private Long prescriptionId;
    @Column(name = "medicine_id")
    private Long medicineId;
    private Integer quantity;
}