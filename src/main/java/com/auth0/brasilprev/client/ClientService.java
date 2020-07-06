package com.auth0.brasilprev.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {
	
	private ClientRepository clientRepository;
	
	public List<Client> getAllClients() throws Exception {
		
		return clientRepository.findAll();
	}

	public Client addClient(Client client) throws Exception {
		
		return clientRepository.save(client);
		
	}
	
	public Client editClient(Long id, Client client) throws Exception {
		Client existingClient = clientRepository.findById(id).get();
        Assert.notNull(existingClient, "Client not found");
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        return clientRepository.save(existingClient);
	}
	
	public void deleteClient(Long id) throws Exception {
		Client clientToDel = clientRepository.findById(id).get();
        clientRepository.delete(clientToDel);
	}
}
