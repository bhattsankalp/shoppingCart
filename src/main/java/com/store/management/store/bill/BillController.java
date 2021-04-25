package com.store.management.store.bill;

import com.store.management.store.bill.interfac.IBillService;
import com.store.management.store.cart.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private IBillService billService;

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }

    @PutMapping
    public ResponseEntity<Bill> generateBill(@RequestBody Bill bill) {
        return ResponseEntity.ok(billService.save(bill));
    }

    @PostMapping
    public ResponseEntity<Bill> generateBillFromCart(@RequestBody ShoppingCart shoppingCart) {
        return ResponseEntity.ok(billService.generate(shoppingCart));
    }
}
