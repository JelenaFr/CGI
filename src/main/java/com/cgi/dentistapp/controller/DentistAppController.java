package com.cgi.dentistapp.controller;


import com.cgi.dentistapp.dto.AppointmentRequest;
import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
public class DentistAppController extends WebMvcConfigurerAdapter {

    private final AppointmentService appointmentService;

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        model.addAttribute("dentists", appointmentService.loadDentistNames());
        model.addAttribute("newAppointment", new Appointment());
        return "form";
    }

    @GetMapping("/results")
    public String showResultForm() {
        return "results";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid @ModelAttribute("newAppointment") AppointmentRequest request, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dentists", appointmentService.loadDentistNames());
            model.addAttribute("newAppointment", new AppointmentRequest());
            return "form";
        }
        appointmentService.updateAppointment(request);
        return "redirect:/results";
    }

}
