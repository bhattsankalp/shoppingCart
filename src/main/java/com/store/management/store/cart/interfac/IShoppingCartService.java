package com.store.management.store.cart.interfac;

import com.store.management.store.cart.ShoppingCart;

public interface IShoppingCartService {
    ShoppingCart addToCart(ShoppingCart shoppingCart);

    void removeFromCart(ShoppingCart shoppingCart);

    void emptyCart(String id);

    ShoppingCart getShoppingCart(String id);
}
