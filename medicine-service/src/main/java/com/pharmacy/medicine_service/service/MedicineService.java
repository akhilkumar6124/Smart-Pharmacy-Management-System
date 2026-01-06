package com.pharmacy.medicine_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.medicine_service.entity.Medicine;
import com.pharmacy.medicine_service.repository.MedicineRepository;

@Service
public class MedicineService{
    @Autowired
    private MedicineRepository medirepo;

    public List<Medicine> getAllMedicines(){
        return medirepo.findAll();
    }
    public Medicine saveMedicine(Medicine medicine){
        return medirepo.save(medicine);
    }
    public void deleteMedicine(Long id){
        medirepo.deleteById(id); 
    }
    public List<Medicine> searchMedicine(String name){
        return medirepo.findByNameIgnoreCase(name);
    }
}