package com.rachelcampbell.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

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

// This represents items that have been added to the order (shopping cart)
@Entity
@Data
@Table(name= "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "product_id")
    private Long productId;

    /*
     * This is creating the relationship with order.
     * There can be one order with many order items in it.
     * */
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private Order order;
}
