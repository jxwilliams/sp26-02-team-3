package com.team3.spartan_vet.service;

import com.team3.spartan_vet.entity.ServiceOffering;
import com.team3.spartan_vet.repository.ServiceOfferingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOfferingService {

    private final ServiceOfferingRepository serviceOfferingRepository;

    public ServiceOfferingService(ServiceOfferingRepository serviceOfferingRepository) {
        this.serviceOfferingRepository = serviceOfferingRepository;
    }

    public List<ServiceOffering> getAllServiceOfferings() {
        return serviceOfferingRepository.findAll();
    }

    public ServiceOffering getServiceOfferingById(Long id) {
        Optional<ServiceOffering> serviceOffering = serviceOfferingRepository.findById(id);
        return serviceOffering.orElse(null);
    }

    public ServiceOffering createServiceOffering(ServiceOffering serviceOffering) {
        return serviceOfferingRepository.save(serviceOffering);
    }

    public ServiceOffering updateServiceOffering(Long id, ServiceOffering updatedServiceOffering) {
        ServiceOffering existingServiceOffering = getServiceOfferingById(id);

        if (existingServiceOffering != null) {
            existingServiceOffering.setServiceName(updatedServiceOffering.getServiceName());
            existingServiceOffering.setPrice(updatedServiceOffering.getPrice());
            return serviceOfferingRepository.save(existingServiceOffering);
        }

        return null;
    }

    public void deleteServiceOffering(Long id) {
        serviceOfferingRepository.deleteById(id);
    }
}