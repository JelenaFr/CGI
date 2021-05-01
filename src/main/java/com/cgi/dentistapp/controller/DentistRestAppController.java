package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
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

@RestController

public class DentistRestAppController {

    @Autowired
    private DentistVisitService dentistVisitService;



    @GetMapping ("/dentists/{dentist}/{visitDate}")
    public String getDetails (@PathVariable ("dentist") String id, @PathVariable("visitDate") String visitDate){
        String result = id+" "+ visitDate;
        System.out.println(result);
        return result;

    }


}
