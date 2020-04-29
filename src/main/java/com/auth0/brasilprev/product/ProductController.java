package com.auth0.brasilprev.product;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;


    @PostMapping
    public void addProduct(@RequestBody Product product) {
    	productRepository.save(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PutMapping("/{id}")
    public void editProduct(@PathVariable long id, @RequestBody Product product) {
    	Product existingProduct = productRepository.findById(id).get();
        Assert.notNull(existingProduct, "Product not found");
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
    	Product productToDel = productRepository.findById(id).get();
    	productRepository.delete(productToDel);
    }
}