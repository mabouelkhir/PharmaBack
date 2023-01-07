package com.example.pharmacyspring.controller;

import com.example.pharmacyspring.entity.Pharmacie;
import com.example.pharmacyspring.entity.Ville;
import com.example.pharmacyspring.entity.Zone;
import com.example.pharmacyspring.repository.PharmacieRepository;
import com.example.pharmacyspring.repository.VilleRepository;
import com.example.pharmacyspring.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("zones")
public class ZoneController {
    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private PharmacieRepository pharmacieRepository;

    @GetMapping("/all")
    public List<Zone> getAllZones(){
        return zoneRepository.findAll();
    }

    @GetMapping("/allz")
    public List<Zone> findZones() {
        return zoneRepository.find();
    }

    @PostMapping("/add")
    public Zone addZone(@RequestBody Zone newZone){
        return zoneRepository.save(newZone);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteZone(@PathVariable (required = true) String id){
        zoneRepository.deleteById(Integer.parseInt(id));
    }
    @GetMapping("/countphaZone")
    public Map<String, Integer> count() {
        Map<String, Integer> map = new HashMap<>();
        for (Zone z : zoneRepository.findAll()) {
            map.put(z.getNom(), z.getPharmacies().size());
        }
        return map;
    }
    @GetMapping("/zone/{zone}")
    public Collection<Pharmacie> getPhByZone(@PathVariable(value = "zone") String zone){
        Zone zone1 = zoneRepository.findByNomContains(zone);
        return zone1.getPharmacies();
    }
    @PutMapping("update/{id}")
    public Zone updateVille(@RequestBody  Zone newZone,@PathVariable (value = "id") int id){
        return zoneRepository.findById(id)
                .map(zone -> {
                    zone.setNom(newZone.getNom());
                    zone.setVille(newZone.getVille());


                    return zoneRepository.save(zone);
                })
                .orElseGet(() -> {
                    newZone.setId(id);
                    return zoneRepository.save(newZone);
                });
    }
    @GetMapping("find/{id}")
    public Zone getZoneById(@PathVariable(value = "id")int id){
        return zoneRepository.findById(id).get();
    }



}
