package com.store.management.store;

import com.store.management.store.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoreApplication
{

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(EstoreApplication.class, args);
    }
}
