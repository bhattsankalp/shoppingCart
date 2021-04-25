package com.store.management.store.cart;

import com.store.management.store.cart.interfac.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShoppingCart> addToCart(@RequestBody ShoppingCart shoppingCart) {
        return ResponseEntity.ok(shoppingCartService.addToCart(shoppingCart));
    }

    @DeleteMapping("/{id}")
    public void emptyCart(@PathVariable String id) {
        shoppingCartService.emptyCart(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable String id) {
        return ResponseEntity.ok(shoppingCartService.getShoppingCart(id));
    }
}
