package com.store.management.store.customer.implementation;

import com.store.management.store.customer.model.Customer;
import com.store.management.store.customer.CustomerRepository;
import com.store.management.store.customer.interfac.ICustomerService;
import com.store.management.store.error.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(String id) {
        if (customerRepository.findById(id).isPresent()) {
            return customerRepository.findById(id).get();
        }
        throw new CustomerNotFoundException();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
