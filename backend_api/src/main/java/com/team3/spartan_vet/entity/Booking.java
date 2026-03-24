package com.team3.spartan_vet.entity;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String petName;
    private String serviceType;
    private String appointmentDate;

    public Booking() {
    }

    public Booking(Long id, String petName, String serviceType, String appointmentDate) {
        this.id = id;
        this.petName = petName;
        this.serviceType = serviceType;
        this.appointmentDate = appointmentDate;
    }

    public Long getId() {
        return id;
    }

    public String getPetName() {
        return petName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}