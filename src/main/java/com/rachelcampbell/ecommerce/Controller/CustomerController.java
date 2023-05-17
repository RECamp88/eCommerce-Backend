package com.rachelcampbell.ecommerce.Controller;

import com.rachelcampbell.ecommerce.Exception.ServicesException;
import com.rachelcampbell.ecommerce.Model.Customer;
import com.rachelcampbell.ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer/")
public class CustomerController {
    private final CustomerService customerService;

    // injecting the CustomerSerivce dependency into CustomerController
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

  /*
    * Customer should be able to register an account.
    * @param customer object to be registered
    * @return the customer that has been registered with a unique id
    * @throws ServicesException customer already exists an error will be thrown stating the user already exists.
    *  */
    @PostMapping("register")
    public Customer registerCustomer(@RequestBody Customer customer) throws ServicesException {
        return customerService.registerCustomer(customer);
    }

    /*
    * Logging in a customer
     *
     * @param customer object that is logging in
     * @return the customer that has logged in
     * @throws ServicexException if customer is not a valid customer.
     */
    @PostMapping("login")
    public Customer loginCustomer(@RequestBody Customer customer) throws ServicesException {
        return customerService.loginCustomer(customer);
    }

    /*
     * This returns the customer by their id
     * @param is the customer's id
     * @return will return a customer object
     */
    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerService.getCustomerById(id);
    }

    /*
     * This adds items to a cart for the customer
     * @param it takes in the customer's id and the prodcut's id
     * @return it returns a customer object
     */
    @PostMapping("{cstId}/addToOrder/{prodId}")
    public Customer addToOrder(@PathVariable long cstId, @PathVariable int prodId){
        return customerService.addToOrder(cstId,prodId);
    }

    /*
     * This will simulate checking out of the order by setting the balance to zero and creating an empty list of products
     * @param takes in the customer's id
     * @return returns the customer object
     */
    @PatchMapping("{id}")
    public Customer emptyOrder(@PathVariable long id){
        return customerService.getCustomerById(id);
    }

}
