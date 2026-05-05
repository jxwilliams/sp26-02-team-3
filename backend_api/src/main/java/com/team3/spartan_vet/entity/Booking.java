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
    private String status;

    public Booking() {
        this.status = "Pending";
    }

    public Booking(Long id, String petName, String serviceType, String appointmentDate, String status) {
        this.id = id;
        this.petName = petName;
        this.serviceType = serviceType;
        this.appointmentDate = appointmentDate;
        this.status = status;
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

    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
        this.status = status;
    }
}