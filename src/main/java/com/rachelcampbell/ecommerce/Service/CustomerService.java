package com.rachelcampbell.ecommerce.Service;

import com.rachelcampbell.ecommerce.Exception.ServicesException;
import com.rachelcampbell.ecommerce.Model.Customer;
import com.rachelcampbell.ecommerce.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    // injecting the customer repo dependency into customerService
    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    /*
     * Customer should be able to register an accoun
     * t.
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
     *
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
     * Updating a customer's information
     *
     * @param customer's id
     * @param customer object
     * @returns the updated customer object
     * */
    public Customer udpateCustomer(long id, Customer customer){
        if(customerRepo.existsById(id)){
            Customer currentCustomer = customerRepo.findById(id).get();
            customer.setId(id);
            currentCustomer = customer;
            return customerRepo.save(currentCustomer);
        }
        return null;
    }
}
