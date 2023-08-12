package com.onlineshoppy.dto;

import com.onlineshoppy.entity.Address;
import com.onlineshoppy.entity.Customer;
import com.onlineshoppy.entity.Order;
import com.onlineshoppy.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
