package com.store.management.store.customer;

import com.store.management.store.customer.implementation.CustomerService;
import com.store.management.store.customer.interfac.ICustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public ICustomerService getCustomerService() {
        return new CustomerService();
    }
}
