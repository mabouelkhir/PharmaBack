package com.example.pharmacyspring.repository;

import com.example.pharmacyspring.entity.UserPharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserPharmacieRepository extends JpaRepository<UserPharmacie,Integer> {
    @Query(value = "select * from user_pharmacie where username =?1 and password =?2 ;",nativeQuery = true)
    UserPharmacie auth(String username, String password);
}
