package com.onlineshoppy.controller;

import com.onlineshoppy.dao.CountryRepository;
import com.onlineshoppy.dao.StateRepository;
import com.onlineshoppy.entity.Country;
import com.onlineshoppy.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CountryAndStateController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @GetMapping("/countries")
    public ResponseEntity<?> getAllCountries()
    {
        List<Country> all = countryRepository.findAll();
        if(all!=null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<String>("No Countries to Show!!",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/states")
    public ResponseEntity<?> getAllStates()
    {
        List<State> all = stateRepository.findAll();
        if(all!=null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<String>("No States to Show!!",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/states/search/findByCountryCode/{code}")
    public ResponseEntity<?> getStateByCountryCode(@PathVariable("code") String code){
        List<State> byCountryCode = stateRepository.findByCountryCode(code);
        return new ResponseEntity<>(byCountryCode,HttpStatus.OK);
    }
}
