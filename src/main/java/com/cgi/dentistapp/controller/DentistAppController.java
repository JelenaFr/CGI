package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        model.addAttribute("newAppointment", new DentistVisitDTO());
        return "form";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid @ModelAttribute("newAppointment") DentistVisitDTO dentistVisitDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        }else

        dentistVisitService.addVisit(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
        model.addAttribute("dentistVisitDTOs", dentistVisitService.findAllAppointments());
        return "redirect:/results";
    }



}
