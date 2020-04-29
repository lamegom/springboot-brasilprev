package com.auth0.brasilprev;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth0.brasilprev.client.ClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAuthBrasilprevClientTests {

	//@Mock
	@Autowired
    private ClientRepository clientRepository;

    @Test
    public void saveClient() {
        assertNotNull(clientRepository.save(MockDomain.getClient()));
    }
    
    @Test
    public void getClientById() {
        assertNotNull(clientRepository.getOne(1L));
    }

}
