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

    // I use this to show all available vets/providers.
    public List<Vet> getAllVets() {
        return vetRepository.findAll();
    }

    // I find one vet by id, or return null if it is not found.
    public Vet getVetById(Long id) {
        Optional<Vet> vet = vetRepository.findById(id);
        return vet.orElse(null);
    }

    // I save a new vet/provider to the database.
    public Vet createVet(Vet vet) {
        return vetRepository.save(vet);
    }

    // I update the vet info without creating a brand new record.
    public Vet updateVet(Long id, Vet updatedVet) {
        Vet existing = getVetById(id);
        if (existing != null) {
            // I keep the same id and just replace the editable fields.
            existing.setName(updatedVet.getName());
            existing.setSpecialty(updatedVet.getSpecialty());
            return vetRepository.save(existing);
        }
        return null;
    }

    // I delete a vet/provider by id.
    public void deleteVet(Long id) {
        vetRepository.deleteById(id);
    }
}
