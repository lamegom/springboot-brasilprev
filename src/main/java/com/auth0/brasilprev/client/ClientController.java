package com.auth0.brasilprev.client;

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
@RequestMapping("/clients")
public class ClientController {

    private ClientRepository clientRepository;


    @PostMapping
    public void addClient(@RequestBody Client client) {
        clientRepository.save(client);
    }

    @GetMapping
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @PutMapping("/{id}")
    public void editClient(@PathVariable long id, @RequestBody Client client) {
    	Client existingClient = clientRepository.findById(id).get();
        Assert.notNull(existingClient, "Client not found");
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        clientRepository.save(existingClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id) {
    	Client clientToDel = clientRepository.findById(id).get();
        clientRepository.delete(clientToDel);
    }
}