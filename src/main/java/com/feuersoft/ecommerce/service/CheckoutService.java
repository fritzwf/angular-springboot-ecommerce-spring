package com.feuersoft.ecommerce.service;

import com.feuersoft.ecommerce.dto.Purchase;
import com.feuersoft.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
