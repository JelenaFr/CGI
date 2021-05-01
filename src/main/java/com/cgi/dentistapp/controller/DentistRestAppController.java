package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.converter.EntityConverter;
import com.cgi.dentistapp.dto.AvailableTimeDTO;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.AvailableTime;
import com.cgi.dentistapp.repository.AvailableTimesRepository;
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
import java.util.Arrays;
import java.util.List;

@RestController

public class DentistRestAppController {

    @Autowired
    private DentistVisitService dentistVisitService;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    AvailableTimesRepository availableTimesRepository;

    @GetMapping ("/dentists/{dentist}/{visitDate}")
    public List<AvailableTimeDTO> getDetails (@PathVariable ("dentist") String id, @PathVariable("visitDate") String visitDate, Model model){

        List<AvailableTime>availableTimeList = availableTimesRepository.findByDentistAndVisitDate(Long.valueOf(id), visitDate);
        List<AvailableTimeDTO> availableTimeDTO = entityConverter.entityToDto2(availableTimeList);
        model.addAttribute("timesAll", availableTimeDTO);
        System.out.println(Arrays.asList(availableTimeDTO));
        String result = id+" "+ visitDate;
        System.out.println(result);
        return availableTimeDTO;

    }



}
