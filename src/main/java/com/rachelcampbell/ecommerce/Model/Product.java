package com.rachelcampbell.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;


// This represents the actual products in inventory
@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    public Double unitPrice;

    public int quantity;

    public String productImg;


    public Product(int id, String name, Double unitPrice, int quantity, String img) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.productImg = img;
    }

    public void increaseQuantity () { this.quantity ++;}

    public void decreaseQuantity () { this.quantity --;}


}
