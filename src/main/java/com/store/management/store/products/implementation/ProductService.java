package com.store.management.store.products.implementation;

import com.store.management.store.error.exception.ProductNotFoundException;
import com.store.management.store.products.Product;
import com.store.management.store.products.ProductRepository;
import com.store.management.store.products.interfac.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(String id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        throw new ProductNotFoundException();
    }
}
