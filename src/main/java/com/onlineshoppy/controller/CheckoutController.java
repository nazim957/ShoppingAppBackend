package com.onlineshoppy.controller;

import com.onlineshoppy.dto.Purchase;
import com.onlineshoppy.dto.PurchaseResponse;
import com.onlineshoppy.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("*")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/purchase")
    public ResponseEntity<?> placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        if(purchaseResponse!=null) {
            return new ResponseEntity<>(purchaseResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error in Adding Order", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
