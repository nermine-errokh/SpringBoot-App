package com.example.products.web;

import com.example.products.Entities.Product;
import com.example.products.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findProduct (@PathVariable Long id) {
        Product product = productRepository.findById(Math.toIntExact(id)).orElse(null);
        return product;
    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(Math.toIntExact(id));
    }
    @PostMapping("/products")
    public Product create(@RequestBody Product p){
       return productRepository.save(p);
    }

    @PutMapping("/products/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product existingProduct = productRepository.findById(Math.toIntExact(id)).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setPrice(updatedProduct.getQuantity());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }



}
