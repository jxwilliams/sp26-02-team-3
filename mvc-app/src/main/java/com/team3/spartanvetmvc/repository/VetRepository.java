package com.team3.spartanvetmvc.repository;

import com.team3.spartanvetmvc.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VetRepository extends JpaRepository<Vet, Long> {

    Optional<Vet> findByUsernameAndPassword(String username, String password);

    Optional<Vet> findByUsername(String username);
}
