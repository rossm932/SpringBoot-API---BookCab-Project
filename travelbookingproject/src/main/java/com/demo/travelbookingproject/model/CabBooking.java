package com.demo.travelbookingproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CabBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromLocation;
    private String toLocation;
    private String typeOfCab;

    // Default constructor (required by JPA)
    public CabBooking() {
    }

    // Parameterized constructor
    public CabBooking(Long id, String fromLocation, String toLocation, String typeOfCab) {
        this.id = id;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.typeOfCab = typeOfCab;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getTypeOfCab() {
        return typeOfCab;
    }

    public void setTypeOfCab(String typeOfCab) {
        this.typeOfCab = typeOfCab;
    }

    // toString method
    @Override
    public String toString() {
        return "CabBooking [id=" + id + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + 
               ", typeOfCab=" + typeOfCab + "]";
    }
}