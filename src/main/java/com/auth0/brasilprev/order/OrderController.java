package com.auth0.brasilprev.order;

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

import com.auth0.brasilprev.product.Product;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    private OrderService orderService;


    @PostMapping
    public ResponseEntity<?> orderRepository(@RequestBody Order order) {

        	try {
        		Order response = orderService.addOrder(order);
        	
        		return ResponseEntity.status(HttpStatus.CREATED).body(response);
        	} catch(Exception e) {
        		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        	}
    }

    @GetMapping
    public ResponseEntity<?> getOrders() {
    	try {
    		List<Order> response = orderService.getAllOrders();
    	
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editOrder(@PathVariable long id, @RequestBody Order order) {
    	try {
    		Order response = orderService.editOrder(id, order);
    	
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable long id) {
    	try {
    		orderService.deleteOrder(id);
    	
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted.");
    	} catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    	}
    }
}