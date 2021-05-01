package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.service.DentistVisitService;
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
    private DentistVisitService dentistVisitService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        model.addAttribute("dentistsAll", dentistVisitService.loadDentistNames());
        model.addAttribute("timesAll", dentistVisitService.loadAvailableTimes());
        model.addAttribute("newAppointment", new DentistVisitDTO());

        return "form";
    }

    @GetMapping("/results")
    public String showResultForm(Model model) {
        model.addAttribute("dentistVisitDTOs", dentistVisitService.findAllAppointments());
        return "results";
    }



    @PostMapping("/")
    public String postRegisterForm(@Valid @ModelAttribute("newAppointment") DentistVisitDTO dentistVisitDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("dentistsAll", dentistVisitService.loadDentistNames());
            model.addAttribute("timesAll", dentistVisitService.loadAvailableTimes());
            model.addAttribute("newAppointment", new DentistVisitDTO());
            return "form";
        } else
            dentistVisitService.addVisit(dentistVisitDTO.getDentist(), dentistVisitDTO.getVisitDate(), dentistVisitDTO.getVisitTime());
        return "redirect:/results";
    }
    @PostMapping("/results/delete")
    public String delete(@RequestParam("visitId") Long id) {
        dentistVisitService.deleteVisitById(id);
        return "redirect:/results";

    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("visitId") Long id, Model theModel) {
        DentistVisitDTO dentistVisitDTO = dentistVisitService.findById(id);
        theModel.addAttribute("visit", dentistVisitDTO);
        return "results/edit-form";
    }

    @GetMapping ("/dentists/{dentist}/{visitDate}/xxxxx")
    public String getDetails (@PathVariable ("dentist") String id, @PathVariable("date") String visitDate){
        String result = id+" "+ visitDate;
        System.out.println(result);
        return result;

    }



//    @CrossOrigin(origins = "/")
//    @RequestMapping(value = "{dentist}/{visitDate}", method = RequestMethod.GET)
//    public @ResponseBody
//    String processAJAXRequest(
//            @RequestParam("dentist") String dentist,
//            @RequestParam("visitDate") String visitDate   ) {
//        String response = "";
//
//        System.out.printlntists
//        ("working");
//        return response;
//    }

}
