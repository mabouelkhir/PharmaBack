package com.example.pharmacyspring.entity;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

@Embeddable
public class DatePharmPk implements Serializable {
    private int pharmacie;
    private int garde;

    private String datedebut;

    public DatePharmPk() {
        super();
    }
    public int getPharmacie() {
        return pharmacie;
    }
    public void setPharmacie(int pharmacie) {
        this.pharmacie = pharmacie;
    }
    public int getGarde() {
        return garde;
    }
    public void setGarde(int garde) {
        this.garde = garde;
    }
    public String getDatedebut() {
        return datedebut;
    }
    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }
    public DatePharmPk(int pharmacie, int garde, String datedebut) {
        super();
        this.pharmacie = pharmacie;
        this.garde = garde;
        this.datedebut = datedebut;
    }


}
