package com.rachelcampbell.ecommerce.DTO;

import lombok.Data;

@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;
}

// This is only used in retrieving an orderTrackingNumber.

