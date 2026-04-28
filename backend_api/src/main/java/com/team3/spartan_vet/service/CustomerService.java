package com.team3.spartan_vet.service;

import com.team3.spartan_vet.entity.Customer;
import com.team3.spartan_vet.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // I save a new customer record in the database.
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // I use this to list all customers.
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // I use Optional here because the customer might not exist.
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // I update the customer if the id matches an existing record.
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    // I only update the fields the customer can change here.
                    customer.setName(updatedCustomer.getName());
                    customer.setEmail(updatedCustomer.getEmail());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    // I remove the customer record from the database.
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
