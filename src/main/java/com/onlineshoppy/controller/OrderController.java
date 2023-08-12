package com.onlineshoppy.controller;

import com.onlineshoppy.dao.CustomerRepository;
import com.onlineshoppy.dao.OrderRepository;
import com.onlineshoppy.entity.Customer;
import com.onlineshoppy.entity.Order;
import com.onlineshoppy.entity.user.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/search/findByCustomerEmail/{email}")
    public ResponseEntity<?> getOrdersByCustomerEmail(@PathVariable("email") String email) {

        List<Order> byCustomerEmailOrderByDateCreatedDesc = orderRepository.findByCustomerEmailOrderByDateCreatedDesc(email);
        if(byCustomerEmailOrderByDateCreatedDesc!=null) {
         //   return new ResponseEntity<>(byCustomerEmailOrderByDateCreatedDesc, HttpStatus.OK);
            return ResponseEntity.ok(byCustomerEmailOrderByDateCreatedDesc);
        }
        return new ResponseEntity<>("No order FOund",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
