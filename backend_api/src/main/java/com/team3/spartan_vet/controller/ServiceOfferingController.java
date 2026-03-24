package com.team3.spartan_vet.controller;

import com.team3.spartan_vet.entity.ServiceOffering;
import com.team3.spartan_vet.service.ServiceOfferingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    public ServiceOfferingController(ServiceOfferingService serviceOfferingService) {
        this.serviceOfferingService = serviceOfferingService;
    }

    @GetMapping
    public List<ServiceOffering> getAllServiceOfferings() {
        return serviceOfferingService.getAllServiceOfferings();
    }

    @GetMapping("/{id}")
    public ServiceOffering getServiceOfferingById(@PathVariable Long id) {
        return serviceOfferingService.getServiceOfferingById(id);
    }

    @PostMapping
    public ServiceOffering createServiceOffering(@RequestBody ServiceOffering serviceOffering) {
        return serviceOfferingService.createServiceOffering(serviceOffering);
    }

    @PutMapping("/{id}")
    public ServiceOffering updateServiceOffering(@PathVariable Long id, @RequestBody ServiceOffering serviceOffering) {
        return serviceOfferingService.updateServiceOffering(id, serviceOffering);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceOffering(@PathVariable Long id) {
        serviceOfferingService.deleteServiceOffering(id);
    }
}