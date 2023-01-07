package com.example.pharmacyspring.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DatePharGarde implements Serializable {


    @EmbeddedId
    private DatePharmPk pk = new DatePharmPk();
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "pharmacie",insertable = false, updatable = false)
    @MapsId("pharmacie")
    private Pharmacie pharmacie;
    @ManyToOne
    @JoinColumn(name = "garde",insertable = false, updatable = false)
    @MapsId("garde")
    private Garde garde;


    public Date getDateFin() {
        return dateFin;
    }


    public void setDateFin(java.util.Date dateFin) {
        this.dateFin= (Date) dateFin;
    }


    public DatePharGarde() {
        super();
    }
    public DatePharGarde(Date dateFin) {
        super();
        this.dateFin = dateFin;
    }
    public DatePharmPk getPk() {
        return pk;
    }
    public void setPk(DatePharmPk pk) {
        this.pk = pk;
    }
    public Pharmacie getPharmacie() {
        return pharmacie;
    }
    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }
    public Garde getGarde() {
        return garde;
    }
    public void setGarde(Garde garde) {
        this.garde = garde;
    }
    public DatePharGarde(Date dateFin, Pharmacie pharmacie, Garde garde) {
        super();
        this.dateFin = dateFin;
        this.pharmacie = pharmacie;
        this.garde = garde;
    }



}

