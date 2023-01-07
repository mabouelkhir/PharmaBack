package com.example.pharmacyspring.repository;

import com.example.pharmacyspring.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Ville findFirstByNomContains(String nom);





}
