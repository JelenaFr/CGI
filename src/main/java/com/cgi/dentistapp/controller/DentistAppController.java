package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.converter.Converter;
import com.cgi.dentistapp.dto.AppointmentDTO;
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
    @Autowired
    private Converter converter;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        model.addAttribute("dentistsAll", appointmentService.loadDentistNames());
        model.addAttribute("newAppointment", new AppointmentDTO());

        return "form";
    }

    @GetMapping("/results")
    public String showResultForm(Model model) {
        model.addAttribute("appointmentDTOs", appointmentService.findAllAppointments());
        return "results";
    }


    @PostMapping("/")
    public String postRegisterForm(@Valid @ModelAttribute("newAppointment") AppointmentDTO appointmentDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("dentistsAll", appointmentService.loadDentistNames());
            model.addAttribute("newAppointment", new AppointmentDTO());
            return "form";
        } else

            appointmentDTO.setIsAvailable(false);
        appointmentService.updateAppointment(converter.dtoToEntity(appointmentDTO));

        //  appointmentService.addAppointment(appointmentDTO.getDentist(), appointmentDTO.getDate(), appointmentDTO.getPeriod());
        return "redirect:/results";
    }

    @PostMapping("/results/delete")
    public String delete(@RequestParam("visitId") Long id) {
        appointmentService.deleteVisitById(id);
        return "redirect:/results";

    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("visitId") Long id, Model theModel) {
        AppointmentDTO appointmentDTO = appointmentService.findById(id);
        theModel.addAttribute("visit", appointmentDTO);
        return "results/edit-form";
    }

    @GetMapping("/dentists/{dentist}/{visitDate}/xxxxx")
    public String getDetails(@PathVariable("dentist") String id, @PathVariable("date") String visitDate) {
        String result = id + " " + visitDate;
        System.out.println(result);
        return result;

    }

}
