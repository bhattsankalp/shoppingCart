package com.store.management.store.bill;

import com.store.management.store.bill.implementation.BillService;
import com.store.management.store.bill.interfac.IBillService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BillConfig {

    @Bean
    public IBillService getBillService() {
        return new BillService();
    }
}
