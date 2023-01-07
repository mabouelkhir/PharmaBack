package com.example.pharmacyspring.controller;

import com.example.pharmacyspring.entity.Pharmacie;
import com.example.pharmacyspring.entity.Ville;
import com.example.pharmacyspring.entity.Zone;
import com.example.pharmacyspring.repository.PharmacieRepository;
import com.example.pharmacyspring.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("pharmacies")
public class PharmacieController {
    @Autowired
    private PharmacieRepository pharmacieRepository;
    @Autowired
    private VilleRepository villeRepository;

    @GetMapping("/all")
    public List<Pharmacie> getAllPharmacies(){
        return pharmacieRepository.findAll();
    }

    @PostMapping("/add")
    public Pharmacie addPharmacies(@RequestBody Pharmacie newPharma){
        return pharmacieRepository.save(newPharma);
    }

    @GetMapping("/user/{user_id}")
    public List<Pharmacie> findByUserPharmacie(@PathVariable(value = "user_id")int user_id){
        return pharmacieRepository.findByUserPharmacie(user_id);
    }
    @GetMapping("/user/{user_id}/valide")
    public List<Pharmacie> findByUserPharmacieValide(@PathVariable(value = "user_id")int user_id){
        return pharmacieRepository.findByUserPharmacieValide(user_id);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePharmacies(@PathVariable (required = true) String id){
        pharmacieRepository.deleteById(Integer.parseInt(id));
    }
    @GetMapping("/{ville}")
    public Collection<Pharmacie> getPharmacieByVille(@PathVariable(value = "ville") String v){
        Ville ville = villeRepository.findFirstByNomContains(v);
        Collection<Zone> zones = ville.getZones();
        List<Pharmacie> pharmacieList = new ArrayList<>();
        for(Zone c:zones){
            for (Pharmacie ph:c.getPharmacies()){
                pharmacieList.add(ph);
            }
        }
        return pharmacieList;
    }


}
