package com.team3.spartan_vet.repository;

import com.team3.spartan_vet.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}