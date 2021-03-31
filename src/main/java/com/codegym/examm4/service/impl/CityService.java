package com.codegym.examm4.service.impl;

import com.codegym.examm4.model.City;
import com.codegym.examm4.repo.CityRepo;
import com.codegym.examm4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepo cityRepo;

    @Override
    public Iterable<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepo.findById(id);
    }

    @Override
    public City save(City city) {
        return cityRepo.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepo.deleteById(id);
    }
}
