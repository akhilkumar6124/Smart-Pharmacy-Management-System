package com.pharmacy.medicine_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.medicine_service.entity.Medicine;
import com.pharmacy.medicine_service.service.MedicineService;


@RestController
@RequestMapping("/api/medicines")
public class MedicineController{
    @Autowired
    private MedicineService mediservice;
    
    @GetMapping
    public List<Medicine> getAll(){
        return mediservice.getAllMedicines();
    }

    @PostMapping
    public Medicine add(@RequestBody Medicine medicine){
        return mediservice.saveMedicine(medicine);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        mediservice.deleteMedicine(id);
    }

    @GetMapping("/{id}")
    public List<Medicine> search(@PathVariable String q){
        return mediservice.searchMedicine(q);
    }
}