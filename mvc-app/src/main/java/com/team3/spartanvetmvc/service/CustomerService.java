package com.team3.spartanvetmvc.service;

import com.team3.spartanvetmvc.entity.Customer;
import com.team3.spartanvetmvc.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer validateCustomer(String username, String password) {
        Optional<Customer> customer = customerRepository.findByUsernameAndPassword(username, password);
        return customer.orElse(null);
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    public boolean usernameExists(String username) {
        return customerRepository.findByUsername(username).isPresent();
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
