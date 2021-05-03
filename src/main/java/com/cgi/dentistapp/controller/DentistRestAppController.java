package com.cgi.dentistapp.controller;


import com.cgi.dentistapp.dto.AppointmentDto;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.AppointmentRepository;
import com.cgi.dentistapp.repository.DentistRepository;
import com.cgi.dentistapp.service.AppointmentService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController

public class DentistRestAppController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DentistRepository dentistRepository;


    @GetMapping("/dentists/{dentist}/{visitDate}")
    public List<AppointmentDto> getDetails(@PathVariable("dentist") String id, @PathVariable("visitDate") String date) {

        Dentist dentist = dentistRepository.findDentistsById(Long.valueOf(id));
        if (appointmentRepository.findAppointmentByDateAndDentist(date, dentist).isEmpty()) {
            val appointments = appointmentService.createSchedule(dentist, date);
            return appointments.stream().map(appointment -> new AppointmentDto(appointment.getPeriod(), appointment.getId()))
                    .collect(Collectors.toList());

        } else {
            val appointments = appointmentRepository.findAppointmentByDentistAndIsAvailableAndDate(dentistRepository.findDentistsById(Long.valueOf(id)), true, date);
            return appointments.stream().map(appointment -> new AppointmentDto(appointment.getPeriod(), appointment.getId()))
                    .collect(Collectors.toList());
        }

    }


}
