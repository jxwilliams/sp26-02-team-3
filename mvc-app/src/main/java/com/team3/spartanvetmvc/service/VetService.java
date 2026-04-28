package com.team3.spartanvetmvc.service;

import com.team3.spartanvetmvc.entity.Vet;
import com.team3.spartanvetmvc.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VetService {

    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public Vet validateProvider(String username, String password) {
        // I use this for the simple provider login check.
        Optional<Vet> vet = vetRepository.findByUsernameAndPassword(username, password);
        return vet.orElse(null);
    }

    public Vet getVetById(Long id) {
        // I use the saved provider id from the session to find the provider again.
        Optional<Vet> vet = vetRepository.findById(id);
        return vet.orElse(null);
    }

    public List<Vet> getAllVets() {
        return vetRepository.findAll();
    }

    public void saveVet(Vet vet) {
        vetRepository.save(vet);
    }

    public boolean usernameExists(String username) {
        return vetRepository.findByUsername(username).isPresent();
    }
}
