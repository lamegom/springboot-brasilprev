package com.auth0.brasilprev.order;

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
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderRepository;


    @PostMapping
    public void orderRepository(@RequestBody Order order) {
    	orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @PutMapping("/{id}")
    public void editOrder(@PathVariable long id, @RequestBody Order order) {
    	Order existingOrder = orderRepository.findById(id).get();
        Assert.notNull(existingOrder, "Order not found");
        existingOrder.setClient(order.getClient());
        existingOrder.setProducts(order.getProducts());
        orderRepository.save(existingOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable long id) {
    	Order productToDel = orderRepository.findById(id).get();
    	orderRepository.delete(productToDel);
    }
}