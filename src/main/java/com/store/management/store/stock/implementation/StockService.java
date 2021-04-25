package com.store.management.store.stock.implementation;

import com.store.management.store.error.exception.ProductNotFoundException;
import com.store.management.store.products.Product;
import com.store.management.store.products.interfac.IProductService;
import com.store.management.store.stock.Stock;
import com.store.management.store.stock.StockRepository;
import com.store.management.store.stock.interfac.IStockService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StockService implements IStockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private IProductService productService;

    @Override
    public boolean isPresent(Product product) {
        Optional<Stock> stock = stockRepository.findById(product.getId());
        return stock.isPresent();
    }

    @Override
    public Stock addStock(Stock stock) {
        Product product = productService.getProductById(stock.getId());
        Optional<Stock> oldStock = stockRepository.findById(product.getId());
        Stock newStock = new Stock();
        newStock.setId(stock.getId());
        if (oldStock.isPresent()) {
            newStock.setStockCount(oldStock.get().getStockCount() + stock.getStockCount());
        } else {
            newStock.setStockCount(stock.getStockCount());
        }
        return stockRepository.save(newStock);
    }

    @Override
    public Stock getStockByProductId(String productId) {
        if (stockRepository.findById(productId).isPresent()) {
            return stockRepository.findById(productId).get();
        }
        throw new ProductNotFoundException();
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }
}
