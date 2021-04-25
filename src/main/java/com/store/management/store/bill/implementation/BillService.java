package com.store.management.store.bill.implementation;

import com.store.management.store.bill.Bill;
import com.store.management.store.bill.BillRepository;
import com.store.management.store.bill.interfac.IBillService;
import com.store.management.store.cart.ShoppingCart;
import com.store.management.store.customer.interfac.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BillService implements IBillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ICustomerService customerService;

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill save(Bill bill) {
        Double totalAmount = bill
                .getProducts()
                .stream()
                .mapToDouble(
                        product -> Double.parseDouble(product.getProductPrice())
                )
                .sum();
        bill.setTotalAmount(totalAmount.toString());
        return billRepository.save(bill);
    }

    @Override
    public Bill generate(ShoppingCart shoppingCart) {
        Bill bill = new Bill();
        bill.setTotalAmount(shoppingCart.getCartTotal());
        bill.setCustomer(customerService.getCustomerById(shoppingCart.getId()));
        bill.setId(shoppingCart.getId() + "_" + OffsetDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMddhhmmss")
        ));
        return billRepository.save(bill);
    }
}
