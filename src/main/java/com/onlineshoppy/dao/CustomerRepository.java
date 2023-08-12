package com.onlineshoppy.dao;


import com.onlineshoppy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public Customer findByEmail(String email);
}
