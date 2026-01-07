package com.pharmacy.prescription_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.prescription_service.entity.Prescription;
import com.pharmacy.prescription_service.entity.PrescriptionItem;
import com.pharmacy.prescription_service.repository.PrescriptionItemRepository;
import com.pharmacy.prescription_service.repository.PrescriptionRepository;

@Service
public class PrescriptionService{
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PrescriptionItemRepository prescriptionItemRepository;

    public Prescription createPrescription(Prescription prescription){
        prescription.setPrescriptionDate(LocalDate.now());
        return prescriptionRepository.save(prescription);
    }

    public PrescriptionItem addItem(PrescriptionItem prescriptionItem){
        return prescriptionItemRepository.save(prescriptionItem);
    }

    public List<PrescriptionItem> getPrescriptionItems(Long prescriptionId){
        return prescriptionItemRepository.findByPrescriptionId(prescriptionId);
    }
}