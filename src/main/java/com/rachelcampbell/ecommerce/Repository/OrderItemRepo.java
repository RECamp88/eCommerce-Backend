package com.rachelcampbell.ecommerce.Repository;

import com.rachelcampbell.ecommerce.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
}


/*
 Some developoers may still untilize the concept of DAO.
Here we are using a package name of Repository instead of naming it DAO, but it is working the same way
 The JPARepository handles all the SQL statements for us which eases our coding load.
You are still able to create customer queries as needed for your project. */