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

import com.auth0.brasilprev.client.Client;
import com.auth0.brasilprev.client.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAuthBrasilprevClientTests {

	@Mock
    private ClientService clientService;

    
    @Test
    public void getClients() throws Exception{
    	
    	 Mockito
         .when(clientService.getAllClients()).thenReturn(Arrays.asList(MockDomain.getClient()));
    	 
    	 List<Client> clients = clientService.getAllClients();
    	 assertThat(clients).hasSize(1);
    }
    

	@Test
	public void testCreateNewObject() throws Exception {


		when(clientService.addClient(isA(Client.class))).thenAnswer(invocation -> (Client) invocation.getArguments()[0]);
		Client returnedObj = clientService.addClient(MockDomain.getClient());
		ArgumentCaptor<Client> savedRestObjectArgument = ArgumentCaptor.forClass(Client.class);
		verify(clientService, times(1)).addClient(savedRestObjectArgument.capture());
		verifyNoMoreInteractions(clientService);

		Client savedRestObject = savedRestObjectArgument.getValue();
		assertThat(savedRestObject).isEqualTo(returnedObj);

		
	}


	@Test
	public void testUpdateObject() throws Exception {
		Client newClient = new Client();
		newClient.setEmail("asdasd");
		newClient.setName("qweqwe");
		
		when(clientService.editClient(isA(Long.class), isA(Client.class))).thenReturn(newClient);
		Client client = clientService.editClient(1L, MockDomain.getClient());
		verify(clientService, times(1)).editClient(1L, MockDomain.getClient());
		assertThat(client.getEmail()).isEqualTo("asdasd");

	}

}
