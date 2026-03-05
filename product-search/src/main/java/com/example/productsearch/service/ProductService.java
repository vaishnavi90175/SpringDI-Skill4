package com.example.productsearch.service;

import com.example.productsearch.entity.Product;
import com.example.productsearch.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Product> getByPriceRange(double min, double max) {
        return repository.findByPriceBetween(min, max);
    }

    public List<Product> getSortedProducts() {
        return repository.sortByPrice();
    }

    public List<Product> getExpensiveProducts(double price) {
        return repository.findExpensiveProducts(price);
    }

    public List<Product> getCategoryJPQL(String category) {
        return repository.getProductsByCategory(category);
    }

    public Product save(Product product) {
        return repository.save(product);
    }
}