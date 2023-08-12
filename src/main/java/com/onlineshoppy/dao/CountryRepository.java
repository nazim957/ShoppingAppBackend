package com.onlineshoppy.dao;

import com.onlineshoppy.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Integer> {
}
