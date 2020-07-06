package com.auth0.brasilprev.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {
	
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrders() throws Exception {
		
		return orderRepository.findAll();
	}

	public Order addOrder(Order order) throws Exception {
		
		return orderRepository.save(order);
		
	}
	
	public Order editOrder(Long id, Order order) throws Exception {
		Order existingOrder = orderRepository.findById(id).get();
        Assert.notNull(existingOrder, "order not found");
        existingOrder.setClient(order.getClient());
        existingOrder.setProducts(order.getProducts());
        return orderRepository.save(existingOrder);
	}
	
	public void deleteOrder(Long id) throws Exception {
		Order orderToDel = orderRepository.findById(id).get();
        orderRepository.delete(orderToDel);
	}
}
