package com.example.demo.controller;


import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.cityservice.CityService;
import com.example.demo.service.countryservice.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @ModelAttribute("country")
    public List<Country> countries() {
        return (List<Country>) countryService.findAll();
    }

    @GetMapping()
    public ModelAndView listCity(){
        return  new ModelAndView("/city/list", "list", cityService.findAll());
    }


    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/city/create", "city", new City());
    }

    @PostMapping("/create")
    public ModelAndView createCity(City city,  RedirectAttributes redirect){
        try {
            cityService.save(city);
            redirect.addFlashAttribute("success","Them moi thanh cong");
            return new ModelAndView("redirect:/city");
        }catch (Exception e){
            return new ModelAndView("/city/create", "city", new City());
        }



    }


    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        return new ModelAndView("/city/edit", "city", cityService.findById(id));
    }

    @PostMapping("/edit")
    public ModelAndView editCity(City city, RedirectAttributes redirect){
        try {
            cityService.save(city);
            redirect.addFlashAttribute("success"," Sua thanh cong");
            return new ModelAndView("redirect:/city");
        }catch (Exception e){
            return new ModelAndView("/city/edit", "city", cityService.findById(city.getId()));
        }


    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id){
        return new ModelAndView("/city/delete", "city", cityService.findById(id));
    }

    @PostMapping("/delete")
    public ModelAndView deleteCity(City city, RedirectAttributes redirect){
        cityService.remove(city.getId());
        redirect.addFlashAttribute("success"," Xoa thanh cong");
        return new ModelAndView("redirect:/city");
    }


    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable Long id){
        return new ModelAndView("/city/view", "city", cityService.findById(id));
    }





}
