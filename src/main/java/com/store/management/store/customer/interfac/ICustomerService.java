package com.store.management.store.customer.interfac;

import com.store.management.store.customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(String id);

    Customer save(Customer customer);

}
