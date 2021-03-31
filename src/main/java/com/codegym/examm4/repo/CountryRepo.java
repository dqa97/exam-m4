package com.codegym.examm4.repo;

import com.codegym.examm4.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepo extends CrudRepository<Country, Long> {
}
