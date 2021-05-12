package com.feuersoft.ecommerce.controller;

import com.feuersoft.ecommerce.dto.Purchase;
import com.feuersoft.ecommerce.dto.PurchaseResponse;
import com.feuersoft.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ffeuerbacher on 5/10/2021
 */

// Allows CORS for this domain
//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    // @Autowired - since we only have one constructor, the autowired is
    // not needed because Spring will know what to use.
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse =  checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}
