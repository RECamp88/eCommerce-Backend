package com.rachelcampbell.ecommerce.Service;

import com.rachelcampbell.ecommerce.DTO.Purchase;
import com.rachelcampbell.ecommerce.DTO.PurchaseResponse;
import com.rachelcampbell.ecommerce.Model.Customer;
import com.rachelcampbell.ecommerce.Model.Order;
import com.rachelcampbell.ecommerce.Model.Product;
import com.rachelcampbell.ecommerce.Repository.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CustomerRepo customerRepo;

    //dependency injection: injecting customer repo into this service class.
    @Autowired
    public CheckoutServiceImpl (CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    //method for placing an order
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve the order info from dto
        Order order = purchase.getOrder();

        // populate order with orderItems
        //get the items from the purchase DTO then loop through them and add them to the order
        List<Product> orderProducts = purchase.getOrderProducts();
        orderProducts.forEach(order::add);

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save to the database
        customerRepo.save(customer);
        //return a response
        return new PurchaseResponse(order.getId() + generateNum() );
    }

    public int generateNum(){
        int min = 10000;
        int max = 400000;
        int random_int = (int)Math.floor((Math.random() * (max - min +1) + min));
        return random_int;
    }
}
