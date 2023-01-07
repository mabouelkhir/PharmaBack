package com.example.pharmacyspring.repository;

import com.example.pharmacyspring.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    Zone findByNomContains(String nom);

    @Query(value= "select * from Zone ",nativeQuery = true)
    List<Zone> find();
}
