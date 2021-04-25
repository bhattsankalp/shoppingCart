package com.store.management.store.bill.interfac;

import com.store.management.store.bill.Bill;
import com.store.management.store.cart.ShoppingCart;

import java.util.List;

public interface IBillService {

    List<Bill> getAllBills();

    Bill save(Bill bill);

    Bill generate(ShoppingCart shoppingCart);
}
