package com.rachelcampbell.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



// This is a basic model of the customer
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String email;

    private String password;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        if (order != null) {

            if (orders == null){
                orders = new ArrayList<>();
            }
            orders.add(order);
            order.setCustomer(this);
        }
    }
}
