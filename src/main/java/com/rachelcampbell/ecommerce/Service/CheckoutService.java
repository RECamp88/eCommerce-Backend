package com.rachelcampbell.ecommerce.Service;

import com.rachelcampbell.ecommerce.DTO.Purchase;
import com.rachelcampbell.ecommerce.DTO.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder (Purchase purchase);
}
