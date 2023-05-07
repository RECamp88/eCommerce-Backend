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

    public Customer registerCustomer(Customer customer) throws ServicesException{
        if(customerRepo.findByEmail(customer.getEmail()) != null) {
            throw new ServicesException("User Already Exists");
        }
        return customerRepo.save(customer);
    }


    public Customer loginCustomer(Customer customer) throws ServicesException{
        Customer customerLogin = (Customer) customerRepo.findByEmail(customer.getEmail());
        if(customerLogin == null || !customerLogin.getPassword().equals(customer.getPassword())) {
            throw new ServicesException("Incorrect email or password");
        }
        return customerLogin;
    }
}
