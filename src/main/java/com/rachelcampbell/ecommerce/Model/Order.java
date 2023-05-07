package com.rachelcampbell.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.*;

// The table name has to have an "s" added to the end because the word "order" is a keyword for SQL
// If you do not make this change, then you will get auto DDL errors when compiling.

//This represents the customer's order.  In our case the order in the shopping cart.
@Entity
@Setter
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private int totalQuantity;

    private BigDecimal totalPrice;

    @CreationTimestamp
    private Date dateCreated;

    @UpdateTimestamp
    private Date lastUpdated;

    /*
    * This creates a relationship with customers.
    * A customer can have many orders.
     */
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;


    /*
     * This is creating the relationship with order items.
     * There can be one order with many order items in it.
     * The "mapped by" is mapping to the object created in the orderItems model for this relationship.
     * Set is being utilized here instead of list to leaverage the characteristic of Set that does not allow for duplicates.
     * Remember there is a quantity field, so you can still have many of the same items without having them in the set individually several times.
     * */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private List<Product> orderProducts = new ArrayList<>();

    public void add(Product item){
        if (item != null){
            if (orderProducts == null) {
                orderProducts = new ArrayList<>();
            }
            orderProducts.add(item);
            item.setOrder(this);
        }
    }

}
