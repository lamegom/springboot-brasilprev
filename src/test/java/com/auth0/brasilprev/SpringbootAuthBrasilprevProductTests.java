package com.auth0.brasilprev;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth0.brasilprev.product.Product;
import com.auth0.brasilprev.product.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAuthBrasilprevProductTests {

	@Mock
    private ProductService productService;

    
    @Test
    public void getProducts() throws Exception{
    	
    	 Mockito
         .when(productService.getAllProducts()).thenReturn(Arrays.asList(MockDomain.getProduct()));
    	 
    	 List<Product> products = productService.getAllProducts();
    	 assertThat(products).hasSize(1);
    }
    

	@Test
	public void testCreateNewObject() throws Exception {


		when(productService.addProduct(isA(Product.class))).thenAnswer(invocation -> (Product) invocation.getArguments()[0]);
		Product returnedObj = productService.addProduct(MockDomain.getProduct());
		ArgumentCaptor<Product> savedRestObjectArgument = ArgumentCaptor.forClass(Product.class);
		verify(productService, times(1)).addProduct(savedRestObjectArgument.capture());
		verifyNoMoreInteractions(productService);

		Product savedRestObject = savedRestObjectArgument.getValue();
		assertThat(savedRestObject).isEqualTo(returnedObj);

		
	}


	@Test
	public void testUpdateObject() throws Exception {
		Product newProduct = new Product();
		newProduct.setPrice(50.0);
		newProduct.setName("qweqwe");
		
		when(productService.editProduct(isA(Long.class), isA(Product.class))).thenReturn(newProduct);
		Product product = productService.editProduct(1L, MockDomain.getProduct());
		verify(productService, times(1)).editProduct(1L, MockDomain.getProduct());
		assertThat(product.getName()).isEqualTo("qweqwe");

	}

}
