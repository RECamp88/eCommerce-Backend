package com.rachelcampbell.ecommerce.Service;

import com.rachelcampbell.ecommerce.Exception.ServicesException;
import com.rachelcampbell.ecommerce.Model.Customer;
import com.rachelcampbell.ecommerce.Model.Product;
import com.rachelcampbell.ecommerce.Repository.CustomerRepo;
import com.rachelcampbell.ecommerce.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;

    // injecting the customer repo dependency into customerService
    @Autowired
    public CustomerService(CustomerRepo customerRepo, ProductRepo productRepo) {

        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    /*
     * Customer should be able to register an account.
     * @param customer object to be registered
     * @return the customer that has been registered with a unique id
     * @throws ServicesException customer already exists an error will be thrown stating the user already exists.
     *  */
    public Customer registerCustomer(Customer customer) throws ServicesException{
        if(customerRepo.findByEmail(customer.getEmail()) != null) {
            throw new ServicesException("User Already Exists");
        }
        return customerRepo.save(customer);
    }

    /*
     * Logging in a customer
     * @param customer object that is logging in
     * @return the customer that has logged in
     * @throws ServicexException if customer is not a valid customer.
     */
    public Customer loginCustomer(Customer customer) throws ServicesException{
        Customer customerLogin = (Customer) customerRepo.findByEmail(customer.getEmail());
        if(customerLogin == null || !customerLogin.getPassword().equals(customer.getPassword())) {
            throw new ServicesException("Incorrect email or password");
        }
        return customerLogin;
    }

    /*
    * This returns the customer by their id
    * @param is the customer's id
    * @return will return a customer object
     */
    public Customer getCustomerById(long id) { return customerRepo.findById(id).get(); }

    /*
    * This adds items to a cart for the customer
    * @param it takes in the customer's id and the prodcut's id
    * @return it returns a customer object
     */
    public Customer addToOrder(long customerId, int prodId) {
        Customer customer = customerRepo.findById(customerId).get();
        Product product = productRepo.findById(prodId).get();
        List<Product> order = customer.getOrder();
        boolean isFound = false;
        // if the item is already part of the order the increase the quantity
        for(Product prod : order){
            if(prod.getId() == product.getId()) {
                prod.increaseQuantity();
                isFound = true;
                break;
            }
        }
        //if the item is not part of the order then set the quantity to 1
        if(!isFound){
            product.setQuantity(1);
            order.add(product);
        }
        //calculate the balance
        customer.setBalance(customer.getBalance() + (product.getUnitPrice() * product.getQuantity()));
        //save the order
        customer.setOrder(order);
         // then save the customer
        return customerRepo.save(customer);
    }

    /*
    * This will simulate checking out of the order by setting the balance to zero and creating an empty list of products
    * @param takes in the customer's id
    * @return returns the customer object
     */
    public Customer checkout(long id){
        Customer customer = customerRepo.findById(id).get();
        //create a new list of products
        List<Product> emptyOrder = new ArrayList<>();
        //set the balance to zero
        customer.setBalance(0);
        customer.setOrder(emptyOrder);

        return customerRepo.save(customer);
    }
}
