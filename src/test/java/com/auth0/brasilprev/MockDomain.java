package com.auth0.brasilprev;

import com.auth0.brasilprev.client.Client;
import com.auth0.brasilprev.product.Product;

public class MockDomain {
	
	public static Client getClient() {
		Client client = new Client();
		client.setId(1L);
		client.setName("Marcio Lamego");
		client.setEmail("lamegom@me.com");
		
		
		return client;
	}

	public static Product getProduct() {
		Product product = new Product();
		product.setName("apple");
		product.setPrice(25.0);
		
		return product;
	}
	


}
