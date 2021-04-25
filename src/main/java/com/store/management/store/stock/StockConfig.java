package com.store.management.store.stock;

import com.store.management.store.stock.implementation.StockService;
import com.store.management.store.stock.interfac.IStockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockConfig {

    @Bean
    public IStockService getStockService() {
        return new StockService();
    }

}
