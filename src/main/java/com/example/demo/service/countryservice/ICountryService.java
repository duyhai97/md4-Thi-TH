package com.example.demo.service.countryservice;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICountryService {

    Iterable<Country> findAll();

    Optional<Country> findById(Long id);

    void save(Country country);

    void remove(Long id);
}
