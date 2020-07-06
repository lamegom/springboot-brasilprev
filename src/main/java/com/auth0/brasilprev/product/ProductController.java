package com.auth0.brasilprev.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.brasilprev.product.Product;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private ProductService productService;


    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
    	try {
    		Product response = productService.addProduct(product);
    	
    		return ResponseEntity.status(HttpStatus.CREATED).body(response);
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    }

    @GetMapping
    public ResponseEntity<?> getProducts() {
    	try {
    		List<Product> response = productService.getAllProducts();
    	
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editProduct(@PathVariable long id, @RequestBody Product product) {
    	try {
    		Product response = productService.editProduct(id, product);
    	
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id) {
    	try {
    		productService.deleteProduct(id);
    	
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted.");
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    }
}