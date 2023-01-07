package com.example.pharmacyspring.controller;

import com.example.pharmacyspring.entity.DatePharGarde;
import com.example.pharmacyspring.entity.Pharmacie;
import com.example.pharmacyspring.entity.Ville;
import com.example.pharmacyspring.repository.DatePharGardeRepository;
import com.example.pharmacyspring.repository.GardeRepository;
import com.example.pharmacyspring.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class DatePharGardeController {
    @Autowired
    DatePharGardeRepository datePharGardeRepository;
    @Autowired
    PharmacieRepository pharmacieRepository;
    @Autowired
    GardeRepository gardeRepository;
    @GetMapping("/pharmacieGarde")
    public List<Pharmacie> getallGards(){
        List<Pharmacie> pharmacieList = new ArrayList<>();
        for(DatePharGarde d:datePharGardeRepository.findAll()){
            if(d.getDateFin() == null)
                pharmacieList.add(d.getPharmacie());
        }
        return pharmacieList;
    }
    @GetMapping("/pharmacieGarde/{id}")
    public Pharmacie finGardByID(@PathVariable(value = "id") int id){
        Pharmacie pharmacie = pharmacieRepository.findById(id);
        DatePharGarde datePharGarde= datePharGardeRepository.findByPharmacie(pharmacie);
        if (datePharGarde.getDateFin() == null){
            datePharGarde.setDateFin(new Date());
            datePharGardeRepository.save(datePharGarde);

        }

        return pharmacie;


    }
    @GetMapping("gardeinfo/all")
    public List<DatePharGarde> getAllGardes(){
        return datePharGardeRepository.findAll();
    }
    @PostMapping("gardeinfo/add")
    public DatePharGarde addGardeTophar(@RequestBody DatePharGarde newgardephar){
        return datePharGardeRepository.save(newgardephar);
    }

}
