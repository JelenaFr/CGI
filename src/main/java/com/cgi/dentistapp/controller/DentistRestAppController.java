package com.cgi.dentistapp.controller;


import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.AppointmentRepository;
import com.cgi.dentistapp.repository.DentistRepository;
import com.cgi.dentistapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class DentistRestAppController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DentistRepository dentistRepository;


    @GetMapping("/dentists/{dentist}/{visitDate}")
    public List<String> getDetails(@PathVariable("dentist") String id, @PathVariable("visitDate") String date, Model model) {
        List<String> availableTimes = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();
        Dentist dentist = dentistRepository.findDentistsById(Long.valueOf(id));
        if (appointmentRepository.findAppointmentByDate(date).isEmpty()) {
            appointmentService.createSchedule(dentist, date);
            appointments = appointmentRepository.findAppointmentByDentistNameAndIsAvailableAndDate(dentistRepository.findDentistsById(Long.valueOf(id)).getName(), true, date);
            appointments.forEach(n -> availableTimes.add(n.getPeriod()));
            availableTimes.forEach(n -> System.out.println("First " + n));

        } else {
            appointments = appointmentRepository.findAppointmentByDentistNameAndIsAvailableAndDate(dentistRepository.findDentistsById(Long.valueOf(id)).getName(), true, date);
            appointments.forEach(n -> availableTimes.add(n.getPeriod()));
            availableTimes.forEach(n -> System.out.println("First " + n));
        }


        String result = id + " " + date;
        System.out.println(result);
        return availableTimes;

    }


}
