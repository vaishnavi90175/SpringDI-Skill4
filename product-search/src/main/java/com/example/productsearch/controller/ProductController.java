package com.example.productsearch.controller;

import com.example.productsearch.entity.Product;
import com.example.productsearch.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // insert product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.save(product);
    }

    // 1 category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    // 2 price filter
    @GetMapping("/filter")
    public List<Product> filterPrice(
            @RequestParam double min,
            @RequestParam double max) {
        return service.getByPriceRange(min, max);
    }

    // 3 sorting
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return service.getSortedProducts();
    }

    // 4 expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return service.getExpensiveProducts(price);
    }
}