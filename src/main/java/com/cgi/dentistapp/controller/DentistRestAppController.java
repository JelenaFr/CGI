package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.AppointmentDto;
import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class DentistRestAppController {

    private final AppointmentService appointmentService;

    @GetMapping("/dentists/{id}/{visitDate}")
    public List<AppointmentDto> getDetails(@PathVariable Long id, @PathVariable("visitDate") String visitDateString) {
        return appointmentService.getAppointmentDetails(id, visitDateString);

    }

    @GetMapping("/results/all")
    @ResponseBody
    public ResponseEntity<List<Appointment>> findAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAllAppointments());
    }

    @PatchMapping("/results/edit/{id}")
    public void editAppointment(@PathVariable Long id) {
        appointmentService.setAvailableById(id);
    }
}
