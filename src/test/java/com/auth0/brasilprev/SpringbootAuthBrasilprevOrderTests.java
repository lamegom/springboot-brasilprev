package com.auth0.brasilprev;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth0.brasilprev.client.Client;
import com.auth0.brasilprev.client.ClientRepository;
import com.auth0.brasilprev.order.Order;
import com.auth0.brasilprev.order.OrderRepository;
import com.auth0.brasilprev.product.Product;
import com.auth0.brasilprev.product.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAuthBrasilprevOrderTests {

	@Mock
    private ClientRepository clientRepository;
	
	@Mock
    private ProductRepository productRepository;
	
	@Autowired
    private OrderRepository orderRepository;

    @Test
    public void saveOrder() {
    	when(clientRepository.getOne(1L)).thenReturn(MockDomain.getClient());
    	when(productRepository.getOne(1L)).thenReturn(MockDomain.getProduct());
    	
    	Client client = clientRepository.getOne(1L);
    	Product product = productRepository.getOne(1L);
    	List<Product> lst = new ArrayList<Product>();
    	lst.add(product);
    	
    	Order order = new Order();
    	order.setClient(client);
    	order.setProducts(lst);
    	
    	
        assertNotNull(orderRepository.save(order));
    }
    
    @Test
    public void getOrderById() {
        assertNotNull(orderRepository.getOne(1L));
    }

}
