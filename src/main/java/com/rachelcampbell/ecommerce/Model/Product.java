package com.rachelcampbell.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
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

// This represents the actual products in inventory
@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;


    private String name;


    private Double unitPrice;


    private String imageUrl;

    public Product(int id, String name, Double unitPrice, String imageUrl) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
    }
}
