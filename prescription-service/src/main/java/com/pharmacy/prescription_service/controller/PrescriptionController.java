package com.pharmacy.prescription_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.prescription_service.entity.Prescription;
import com.pharmacy.prescription_service.entity.PrescriptionItem;
import com.pharmacy.prescription_service.service.PrescriptionService;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController{
    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public Prescription create(@RequestBody Prescription prescription){
        return prescriptionService.createPrescription(prescription);
    }

    @PostMapping("/items")
    public PrescriptionItem additem(@RequestBody PrescriptionItem prescriptionItem){
        return prescriptionService.addItem(prescriptionItem);
    }

    @GetMapping("/{id}/items")
    public List<PrescriptionItem> getItems(@PathVariable Long prescriptionid){
        return prescriptionService.getPrescriptionItems(prescriptionid);
    }
}