package com.store.management.store.bill;

import com.store.management.store.customer.model.Customer;
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
public class Bill {

    // id = cartId+"_"+CurrentTime
    @Id
    private String id;
    private Customer customer;
    private List<Product> products;
    private String totalAmount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;
        Bill bill = (Bill) o;
        return id.equals(bill.id) &&
                customer.equals(bill.customer) &&
                products.equals(bill.products) &&
                totalAmount.equals(bill.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, products, totalAmount);
    }
}
