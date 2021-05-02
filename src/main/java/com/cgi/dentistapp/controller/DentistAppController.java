package com.cgi.dentistapp.controller;


import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private AppointmentService appointmentService;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        model.addAttribute("dentistsAll", appointmentService.loadDentistNames());
        model.addAttribute("newAppointment", new Appointment());
        return "form";
    }

    @GetMapping("/results")
    public String showResultForm(Model model) {
        model.addAttribute("appointmentDTOs", appointmentService.findAllAppointments());
        return "results";
    }


    @PostMapping("/")
    public String postRegisterForm(@Valid @ModelAttribute("newAppointment") Appointment appointment, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("dentistsAll", appointmentService.loadDentistNames());
            model.addAttribute("newAppointment", new Appointment());
            return "form";
        } else

            appointmentService.updateAppointment(appointment);

        //appointmentService.addAppointment(appointmentDTO.getDentist(), appointmentDTO.getDate(), appointmentDTO.getPeriod());
        return "redirect:/results";
    }

    @PostMapping("/results/delete")
    public String delete(@RequestParam("visitId") Long id) {
        appointmentService.deleteVisitById(id);
        return "redirect:/results";

    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("visitId") Long id, Model theModel) {
        Appointment appointment = appointmentService.findById(id);
        theModel.addAttribute("visit", appointment);
        return "results/edit-form";
    }



}
