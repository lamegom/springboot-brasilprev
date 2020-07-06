package com.auth0.brasilprev.client;

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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private ClientService clientService;


    @PostMapping
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        
    	try {
    		Client response = clientService.addClient(client);
    	
    		return ResponseEntity.status(HttpStatus.CREATED).body(response);
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    }

    @GetMapping
    public ResponseEntity<?> getClients() {
    	
    	try {
    		List<Client> clients = clientService.getAllClients();
    	
    		return ResponseEntity.status(HttpStatus.OK).body(clients);
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    	
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editClient(@PathVariable long id, @RequestBody Client client) {
    	
    	try {
    		Client response = clientService.editClient(id, client);
    	
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    	
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable long id) {
    	
    	try {
    		clientService.deleteClient(id);
    	
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted.");
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    	
    }
}