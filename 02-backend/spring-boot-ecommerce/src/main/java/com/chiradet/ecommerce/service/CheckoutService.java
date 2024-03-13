package com.chiradet.ecommerce.service;

import com.chiradet.ecommerce.dto.Purchase;
import com.chiradet.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
