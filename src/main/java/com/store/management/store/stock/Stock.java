package com.store.management.store.stock;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    //id = product id, each product will have an entry in stock
    @Id
    private String id;
    private Integer stockCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return id.equals(stock.id) &&
                stockCount.equals(stock.stockCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stockCount);
    }
}
