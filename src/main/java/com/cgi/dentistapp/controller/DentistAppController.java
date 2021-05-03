package com.cgi.dentistapp.controller;


import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.service.AppointmentService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("appointments", appointmentService.findAllAppointments());
        return "results";
    }


    @PostMapping("/")
    public String postRegisterForm(@Valid @ModelAttribute("newAppointment") AppointmentRequest request, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("dentistsAll", appointmentService.loadDentistNames());
            model.addAttribute("newAppointment", new AppointmentRequest());
            return "form";
        } else

            appointmentService.updateAppointment(request);
        return "redirect:/results";
    }


    @PostMapping("/results/{id}/edit")
    public String deleteAppointment(Model model, @PathVariable("id") Long id, @ModelAttribute("appointment") Appointment appointment) {
        appointmentService.deleteVisitById(id);
        model.addAttribute("appointment", appointment);
        return "redirect:/results";
    }

    @PostMapping("/results/{id}/showFormForUpdate")
    public String showFormForUpdate(Model model, @PathVariable("id") Long id) {
        val appointment = appointmentService.findById(id);
        appointment.setIsAvailable(true);
        appointmentService.save(appointment);
        return "redirect:/";
    }


}
