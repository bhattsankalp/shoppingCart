package com.store.management.store.cart;

import com.store.management.store.cart.implementation.ShoppingCartService;
import com.store.management.store.cart.interfac.IShoppingCartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShoppingCartConfig {

    @Bean
    public IShoppingCartService getShoppingCartService() {
        return new ShoppingCartService();
    }
}
