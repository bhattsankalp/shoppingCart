package com.store.management.store.products;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private String id;
    private String productName;
    private String productPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                productName.equals(product.productName) &&
                productPrice.equals(product.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productPrice);
    }

}
