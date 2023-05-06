package com.rachelcampbell.ecommerce.DTO;

import com.rachelcampbell.ecommerce.Model.OrderItem;
import lombok.Data;
import com.rachelcampbell.ecommerce.Model.Customer;
import com.rachelcampbell.ecommerce.Model.Address;
import com.rachelcampbell.ecommerce.Model.Order;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}

/*
* This Data Transfer Object puts everything together in one neat package.
* It is basically a table of objects
* It allows for easy access to all the information needed to complete all transactions.
 */