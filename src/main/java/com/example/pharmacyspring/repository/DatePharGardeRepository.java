package com.example.pharmacyspring.repository;

import com.example.pharmacyspring.entity.DatePharGarde;
import com.example.pharmacyspring.entity.DatePharmPk;
import com.example.pharmacyspring.entity.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatePharGardeRepository   extends JpaRepository<DatePharGarde, DatePharmPk> {
    DatePharGarde findByPharmacie(Pharmacie pharmacie);

}
