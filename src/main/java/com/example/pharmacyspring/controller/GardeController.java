package com.example.pharmacyspring.controller;

import com.example.pharmacyspring.entity.Garde;
import com.example.pharmacyspring.entity.Ville;
import com.example.pharmacyspring.repository.GardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController

@RequestMapping("gardes")
public class GardeController {
    @Autowired
    private GardeRepository gardeRepository;


    @PostMapping("/add")
    public Garde addGarde(@RequestBody Garde newGarde){
        return gardeRepository.save(newGarde);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteGarde(@PathVariable (required = true) String id){
        gardeRepository.deleteById(Integer.parseInt(id));
    }
    @GetMapping("/all")
    public List<Garde> findAll(){
        return gardeRepository.findAll();
    }
}
