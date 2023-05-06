package com.rachelcampbell.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
/*
 * This current project is untilizing mySQL which I have installed on my computer.
 * For deployment, I plan on utilizng AWS EC2 and RDS
 * Normally if you are utilizing a database such as H2, you would not need to utilize the @Column annotation
 * This is used because I am mapping to the tables that were created in mySQL
 * If you wanted to utilize H2 instead, you would need to add the dependency into the pom.xml instead of the mysql dependency.
 * Also, you would need to update the application.properties files.
 * This may also need to be done if you plan to preload data and schema by utilizing data.sql and schema.sql files.
 * UPDATE: although not a requirement (unless using data.sql and schema.sql) the @Column annotations can be skipped.
 * By default, the column names will be used by the JPA.
 * A great reason to use them is to declare explictly the names you are wanting to utilize.  This way in the future
 * if the schema does change, you can easily just update it here through the use of these annotations.
 * */
// The table name has to have an "s" added to the end because the word "order" is a keyword for SQL
// If you do not make this change, then you will get auto DDL errors when compiling.

//This represents the customer's order.  In our case the order in the shopping cart.
@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "id")
    private String status;

    @Column(name = "date_created")
    @CreationTimestamp
    private Timestamp dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Timestamp lastUpdated;

    /*
    * This creates a relationship with customers.
    * A customer can have many orders.
     */
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billingAddress;
    /*
     * This is creating the relationship with order items.
     * There can be one order with many order items in it.
     * The "mapped by" is mapping to the object created in the orderItems model for this relationship.
     * Set is being utilized here instead of list to leaverage the characteristic of Set that does not allow for duplicates.
     * Remember there is a quantity field, so you can still have many of the same items without having them in the set individually several times.
     * */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private Set<OrderItem> orderItems = new HashSet<>();

    public void add(OrderItem item){
        if (item != null){
            if (orderItems == null) {
                orderItems = new HashSet<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }

}
