package com.rachelcampbell.ecommerce.DTO;


import com.rachelcampbell.ecommerce.Model.Product;
import lombok.Data;
import com.rachelcampbell.ecommerce.Model.Customer;
import com.rachelcampbell.ecommerce.Model.Order;

import java.util.List;
import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Order order;
    private List<Product> orderProducts;

}

/*
* This Data Transfer Object puts everything together in one neat package.
* It is basically a table of objects
* It allows for easy access to all the information needed to complete all transactions.
 */