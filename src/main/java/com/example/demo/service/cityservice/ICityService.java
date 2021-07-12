package com.example.demo.service.cityservice;

import com.example.demo.model.City;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICityService {

    Iterable<City> findAll();

    Optional<City> findById(Long id);

    void save(City city);

    void remove(Long id);
}
