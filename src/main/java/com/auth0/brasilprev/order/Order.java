package com.auth0.brasilprev.order;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.auth0.brasilprev.client.Client;
import com.auth0.brasilprev.product.Product;

import lombok.Data;

@Entity(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

}