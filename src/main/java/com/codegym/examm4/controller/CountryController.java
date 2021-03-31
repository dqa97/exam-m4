package com.codegym.examm4.controller;

import com.codegym.examm4.model.City;
import com.codegym.examm4.model.Country;
import com.codegym.examm4.service.ICityService;
import com.codegym.examm4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @GetMapping("/createCountry")
    public ModelAndView createCountryForm(){
        ModelAndView modelAndView = new ModelAndView("country");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @PostMapping("/createCountry")
    public ModelAndView createCountry(@ModelAttribute Country country){
        countryService.save(country);
        ModelAndView modelAndView = new ModelAndView("country", "message", "Tạo Quốc Gia thành công");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createCityForm(){
        List<Country> countryList = (List<Country>) countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("city", "city", new City());
        modelAndView.addObject("countryList",countryList);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@ModelAttribute City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city","message","Tạo Thành Phố Thành Công");
        return modelAndView;
    }
}
