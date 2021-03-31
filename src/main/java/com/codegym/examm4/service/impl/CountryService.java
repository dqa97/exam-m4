package com.codegym.examm4.service.impl;

import com.codegym.examm4.model.Country;
import com.codegym.examm4.repo.CountryRepo;
import com.codegym.examm4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CountryService implements ICountryService {

    @Autowired
    private CountryRepo countryRepo;
    @Override
    public Iterable<Country> findAll() {
        return countryRepo.findAll() ;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepo.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepo.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepo.deleteById(id);
    }
}
