package com.rachelcampbell.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

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

//This entity represents the different categories of items that can be ordered.
@Entity
@Table(name = "product_category")
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    /*
    * This is creating the relationship with products.
    * There can be one category with many products in it.
    * The "mapped by" is mapping to the object created in the product model for this relationship.
    * Set is being utilized here instead of list to leaverage the characteristic of Set that does not allow for duplicates.
    * */
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "category")
    @JsonManagedReference
    private Set<Product> products;
}
