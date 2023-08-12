package com.onlineshoppy.dao;

import com.onlineshoppy.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Integer> {

    List<State> findByCountryCode(String code);
}
