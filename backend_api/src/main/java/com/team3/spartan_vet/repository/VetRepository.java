package com.team3.spartan_vet.repository;

import com.team3.spartan_vet.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}