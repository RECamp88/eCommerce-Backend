package com.rachelcampbell.ecommerce.Service;

import com.rachelcampbell.ecommerce.DTO.Purchase;
import com.rachelcampbell.ecommerce.DTO.PurchaseResponse;
import com.rachelcampbell.ecommerce.Model.Customer;
import com.rachelcampbell.ecommerce.Model.Order;
import com.rachelcampbell.ecommerce.Model.OrderItem;
import com.rachelcampbell.ecommerce.Repository.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

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
        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        //get the items from the purchase DTO then loop through them and add them to the order
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //populate order with billingAddress and ShippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save to the database
        customerRepo.save(customer);
        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate a random UUID
        // a UUID (Universally Unique IDentifier)
       return UUID.randomUUID().toString();
    }
}
