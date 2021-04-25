package com.store.management.store.products;

import com.store.management.store.products.implementation.ProductService;


import com.store.management.store.products.interfac.IProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public IProductService getProductService() {
        return new ProductService();
    }
}
