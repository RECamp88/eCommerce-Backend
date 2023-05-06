package com.rachelcampbell.ecommerce.Controller;

import com.rachelcampbell.ecommerce.DTO.Purchase;
import com.rachelcampbell.ecommerce.DTO.PurchaseResponse;
import com.rachelcampbell.ecommerce.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/checkout/")
public class CheckoutController {
    private CheckoutService checkoutService;

    //injects the dependency of the CheckoutService into the controller
    @Autowired
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("purchase")
    public ResponseEntity<PurchaseResponse>  placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return new ResponseEntity<PurchaseResponse>(purchaseResponse, HttpStatus.OK);
    }


}
