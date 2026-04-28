package com.team3.spartanvetmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String petName;
    private String providerName;
    private String serviceType;
    private String appointmentDate;
    private String status = "Pending";

    public Booking() {
    }

    public Booking(Long id, String customerName, String petName, String providerName, String serviceType, String appointmentDate, String status) {
        this.id = id;
        this.customerName = customerName;
        this.petName = petName;
        this.providerName = providerName;
        this.serviceType = serviceType;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    // If no status is set yet, start the booking as Pending.
    @PrePersist
    public void setDefaultStatus() {
        if (status == null || status.isBlank()) {
            status = "Pending";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
