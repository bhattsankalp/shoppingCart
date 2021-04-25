package com.store.management.store.products.interfac;

import com.store.management.store.products.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    Product save(Product product);

    Product getProductById(String id);
}
