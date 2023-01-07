package com.example.pharmacyspring.controller;

import com.example.pharmacyspring.entity.Pharmacie;
import com.example.pharmacyspring.entity.Ville;
import com.example.pharmacyspring.entity.Zone;
import com.example.pharmacyspring.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("villes")
public class VilleController {
    @Autowired
    private VilleRepository villeRepository;
    @GetMapping("/all")
    public List<Ville> getAllVilles(){
        return villeRepository.findAll();
    }

    @PostMapping("/add")
    public Ville addVille(@RequestBody Ville newVille){
        return villeRepository.save(newVille);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteVille(@PathVariable (required = true) String id){
       villeRepository.deleteById(Integer.parseInt(id));
    }
    @GetMapping("/countpharma")
    public Map<String, Integer> count() {
        Map<String, Integer> map = new HashMap<>();
        for (Ville v : villeRepository.findAll()) {
            map.put(v.getNom(), v.getZones().size());
        }
        return map;
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
    @PutMapping("update/{id}")
    public Ville updateVille(@RequestBody Ville newVille,@PathVariable (value = "id") int id){
        return villeRepository.findById(id)
                .map(recharge -> {
                    recharge.setNom(newVille.getNom());

                    return villeRepository.save(recharge);
                })
                .orElseGet(() -> {
                    newVille.setId(id);
                    return villeRepository.save(newVille);
                });
    }
    @GetMapping("find/{id}")
    public Ville getVilleById(@PathVariable(value = "id")int id){
        return villeRepository.findById(id).get();
    }





}
