package com.store.management.store.cart.implementation;

import com.store.management.store.cart.ShoppingCart;
import com.store.management.store.cart.ShoppingCartRepository;
import com.store.management.store.cart.interfac.IShoppingCartService;
import com.store.management.store.error.exception.EmptyCartException;
import com.store.management.store.error.exception.ProductNotFoundException;
import com.store.management.store.products.Product;
import com.store.management.store.stock.Stock;
import com.store.management.store.stock.StockRepository;
import com.store.management.store.stock.interfac.IStockService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private IStockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public ShoppingCart addToCart(ShoppingCart shoppingCart) {
        if (!stockService.isPresent(shoppingCart.getProducts().get(0))) {
            throw new ProductNotFoundException();
        }
        Stock stock = stockService.getStockByProductId(shoppingCart.getProducts().get(0).getId());
        if (stock.getStockCount() < shoppingCart.getProducts().size()) {
            throw new ProductNotFoundException();
        }
        ShoppingCart shoppingCartFromDB = extractCartDetails(shoppingCart.getId());
        removeProductsFromStock(shoppingCart, stock);
        if (Objects.nonNull(shoppingCartFromDB)) {
            shoppingCart.getProducts().addAll(shoppingCartFromDB.getProducts());
        }
        return shoppingCartRepository.save(shoppingCart);
    }

    /**
     * Takes the Cart and removed product from stock
     *
     * @param shoppingCart : Shopping cart to be removed from stock
     * @param stock        : Stock object to be updated
     */
    private void removeProductsFromStock(ShoppingCart shoppingCart, Stock stock) {
        stock.setStockCount(stock.getStockCount() - shoppingCart.getProducts().size());
        stockRepository.save(stock);
    }

    @Override
    public void removeFromCart(ShoppingCart shoppingCart) {
        ShoppingCart shoppingCartFromDB = extractCartDetails(shoppingCart.getId());
        if (Objects.isNull(shoppingCartFromDB)) {
            throw new EmptyCartException();
        }
        shoppingCartFromDB.getProducts().remove(shoppingCart.getProducts().get(0));
    }

    @Override
    public void emptyCart(String id) {
        ShoppingCart shoppingCart = extractCartDetails(id);
        if (Objects.isNull(shoppingCart)) {
            return;
        }
        addCartProductToStock(shoppingCart);
        shoppingCartRepository.delete(shoppingCart);
    }

    /**
     * Empty the cart and all the products to the stock
     *
     * @param shoppingCart : Takes the product in <b>shoppingCart</b> and add it to the stock
     */
    private void addCartProductToStock(ShoppingCart shoppingCart) {
        Map<String, Integer> stockMap = extractStockFromCart(shoppingCart);
        for (Map.Entry<String, Integer> entry : stockMap.entrySet()) {
            Stock stock = new Stock(entry.getKey(), entry.getValue());
            stockService.addStock(stock);
        }
    }

    /**
     * Extracts a map, product id as key and product count as count
     *
     * @param shoppingCart Takes the product in <b>shoppingCart</b> and creates a map
     * @return Map of productId, count
     */
    private Map<String, Integer> extractStockFromCart(ShoppingCart shoppingCart) {
        Map<String, Integer> stockMap = new HashMap<>();
        for (Product product : shoppingCart.getProducts()) {
            Stock stock = new Stock();
            stock.setId(product.getId());
            stock.setStockCount(1);
            if (stockMap.containsKey(product.getId())) {
                stockMap.put(product.getId(), stockMap.get(product.getId()) + 1);
            } else {
                stockMap.put(product.getId(), 1);
            }
        }
        return stockMap;
    }

    @Override
    public ShoppingCart getShoppingCart(String id) {
        if (shoppingCartRepository.findById(id).isPresent()) {
            shoppingCartRepository.findById(id).get();
        }
        return null;
    }

    /**
     * Extract cart details from customer id
     *
     * @param id : <b>id</b> of cart to be extracted
     * @return shoppingCart
     */
    private ShoppingCart extractCartDetails(String id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);
        if (shoppingCart.isEmpty()) {
            return null;
        }
        return shoppingCart.get();
    }
}
