package com.store.management.store.cart;

import com.store.management.store.products.Product;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCart {

    //id = customer Id
    @Id
    private String id;
    private List<Product> products;
    private String cartTotal;

    public String getCartTotal() {
        Double total = this.products
                .stream()
                .mapToDouble(product -> Double.parseDouble(product.getProductPrice()))
                .sum();
        return total.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCart)) return false;
        ShoppingCart that = (ShoppingCart) o;
        return id.equals(that.id) &&
                products.equals(that.products) &&
                cartTotal.equals(that.cartTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, cartTotal);
    }
}
