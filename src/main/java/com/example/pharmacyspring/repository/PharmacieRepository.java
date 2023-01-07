package com.example.pharmacyspring.repository;

import com.example.pharmacyspring.entity.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {
    Pharmacie findById(int id);

    @Query(value ="select * from pharmacie where user_pharmacie_id=?1",nativeQuery = true)
    List<Pharmacie> findByUserPharmacie(int user_id);

    @Query(value ="select * from pharmacie where user_pharmacie_id=?1 and etat = 1",nativeQuery = true)
    List<Pharmacie> findByUserPharmacieValide(int user_id);

}
