package com.example.pharmacyspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String adresse;
    private double latitude;
    private double longitude;
    @Enumerated
    private Etat etat;

    @ManyToOne
    private Zone zone ;



    @ManyToOne
    private UserPharmacie userPharmacie;




    public Pharmacie() {
        super();
    }
    public Pharmacie(String nom, String adresse, Double latitude, double longitude, Zone zone ,Etat etat,UserPharmacie userPharmacie) {
        super();
        this.nom = nom;
        this.adresse = adresse;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zone= zone ;
        this.etat= etat ;
        this.userPharmacie=userPharmacie;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public Zone getZone() {
        return zone;
    }
    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public Pharmacie(int id, String nom, String adresse, double latitude, double longitude,  Zone zone,Etat etat) {
        super();
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zone = zone;
        this.etat=etat;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public UserPharmacie getUserPharmacie() {
        return userPharmacie;
    }

    public void setUserPharmacie(UserPharmacie userPharmacie) {
        this.userPharmacie = userPharmacie;
    }


}
