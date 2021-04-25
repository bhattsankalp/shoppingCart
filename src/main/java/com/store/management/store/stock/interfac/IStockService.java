package com.store.management.store.stock.interfac;

import com.store.management.store.products.Product;
import com.store.management.store.stock.Stock;

import java.util.List;

public interface IStockService {

    boolean isPresent(Product product);

    Stock addStock(Stock stock);

    Stock getStockByProductId(String productId);

    List<Stock> getAllStock();

}
