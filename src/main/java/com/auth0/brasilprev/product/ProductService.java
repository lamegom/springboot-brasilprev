package com.auth0.brasilprev.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {
	
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() throws Exception {
		
		return productRepository.findAll();
	}

	public Product addProduct(Product product) throws Exception {
		
		return productRepository.save(product);
		
	}
	
	public Product editProduct(Long id, Product product) throws Exception {
		Product existingproduct = productRepository.findById(id).get();
        Assert.notNull(existingproduct, "product not found");
        existingproduct.setName(product.getName());
        existingproduct.setPrice(product.getPrice());
        return productRepository.save(existingproduct);
	}
	
	public void deleteProduct(Long id) throws Exception {
		Product productToDel = productRepository.findById(id).get();
        productRepository.delete(productToDel);
	}
}
