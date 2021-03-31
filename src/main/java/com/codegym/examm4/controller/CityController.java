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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @GetMapping("/view")
    private ModelAndView cityView(@RequestParam("id") Long id){
        Optional<City> cityOptional = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("viewcity","city",cityOptional.get());
        return modelAndView;
    }

    @GetMapping("/edit")
    private ModelAndView cityEditForm(@RequestParam("id") Long id){
        List<Country> countryList = (List<Country>) countryService.findAll();
        Optional<City> cityOptional = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit","city",cityOptional.get());
        modelAndView.addObject("countryList",countryList);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView createCity(@ModelAttribute City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("message","Sửa Thành Phố Thành Công");
        return modelAndView;
    }

    @GetMapping("/delete")
    private ModelAndView deleteCityView(@RequestParam("id") Long id){
        Optional<City> cityOptional = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete","city",cityOptional.get());
        return modelAndView;
    }
    @PostMapping("/delete")
    private ModelAndView deleteCity(@RequestParam("id") Long id){
        cityService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @GetMapping("/deleteCountry")
    private ModelAndView deleteCountry(@RequestParam("id") Long id){
        countryService.remove(id);
        return new ModelAndView("redirect:/countries");
    }

    @GetMapping("/countries")
    private ModelAndView listCountry(){
        List<Country> countries = (List<Country>) countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("listcountry", "countries", countries);
        return modelAndView;
    }
}
