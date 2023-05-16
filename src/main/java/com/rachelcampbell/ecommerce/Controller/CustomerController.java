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
    * Updating a customer's information
    *
    * @param customer's id
    * @param customer object
    * @returns the updated customer object
    * */
    @PatchMapping("customer/{id}")
    public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer){
        return customerService.udpateCustomer(id, customer);
    }

}
