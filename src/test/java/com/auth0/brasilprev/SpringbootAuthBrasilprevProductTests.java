package com.auth0.brasilprev;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth0.brasilprev.product.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAuthBrasilprevProductTests {

	//@Mock
	@Autowired
    private ProductRepository productRepository;

    @Test
    public void saveProduct() {
        assertNotNull(productRepository.save(MockDomain.getProduct()));
    }
    
    @Test
    public void getProductById() {
        assertNotNull(productRepository.getOne(1L));
    }

}
