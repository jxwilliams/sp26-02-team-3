package com.team3.spartan_vet.service;

import com.team3.spartan_vet.entity.Vet;
import com.team3.spartan_vet.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VetService {

    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public List<Vet> getAllVets() {
        return vetRepository.findAll();
    }

    public Vet getVetById(Long id) {
        Optional<Vet> vet = vetRepository.findById(id);
        return vet.orElse(null);
    }

    public Vet createVet(Vet vet) {
        return vetRepository.save(vet);
    }

    public Vet updateVet(Long id, Vet updatedVet) {
        Vet existing = getVetById(id);
        if (existing != null) {
            existing.setName(updatedVet.getName());
            existing.setSpecialty(updatedVet.getSpecialty());
            return vetRepository.save(existing);
        }
        return null;
    }

    public void deleteVet(Long id) {
        vetRepository.deleteById(id);
    }
}