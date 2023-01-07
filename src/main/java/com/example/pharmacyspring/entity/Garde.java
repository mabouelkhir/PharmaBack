package com.example.pharmacyspring.entity;

import jakarta.persistence.*;

@Entity
public class Garde {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;
    @Enumerated
    private TypeDeGarde type;




    public Garde() {
        super();
    }
    public Garde(int id, TypeDeGarde type) {
        super();
        this.id = id;
        this.type = type;
    }

    public Garde(TypeDeGarde type) {
        super();
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public TypeDeGarde getType() {
        return type;
    }
    public void setType(TypeDeGarde type) {
        this.type = type;
    }


}



