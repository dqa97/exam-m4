package com.codegym.examm4.controller;

import com.codegym.examm4.model.City;
import com.codegym.examm4.service.ICityService;
import com.codegym.examm4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class MainWebController {

    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @GetMapping("/")
    private ModelAndView mainView(){
        List<City> cityList = (List<City>) cityService.findAll();
        ModelAndView model = new ModelAndView("index","cityList",cityList);
        return model;
    }
}
