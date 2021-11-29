package com.cgi.dentistapp.service;

import com.cgi.dentistapp.dto.AppointmentRequest;
import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.AppointmentRepository;
import com.cgi.dentistapp.repository.DentistRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @InjectMocks
    private AppointmentService service;
    @Mock
    private AppointmentRepository appointmentRepository;
    @Mock
    private DentistRepository dentistRepository;

    @Test
    public void updateAppointment() {
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        Mockito.when(appointmentRepository.findAppointmentById(appointment.getId())).thenReturn(appointment);
        service.updateAppointment(new AppointmentRequest(appointment.getId()));
        Mockito.verify(appointmentRepository).save(Mockito.any(Appointment.class));
    }

    @Test
    public void findAllAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        Mockito.when(appointmentRepository.findAppointmentByIsAvailable(false)).thenReturn(appointments);
        List<Appointment> result = service.findAllAppointments();
        Mockito.verify(appointmentRepository).findAppointmentByIsAvailable(false);
        Assertions.assertEquals(appointments, result);
    }

    @Test
    public void createSchedule() {
        List<Appointment> result = service.createSchedule(new Dentist(), LocalDate.now());
        Mockito.verify(appointmentRepository, Mockito.times(8)).save(Mockito.any(Appointment.class));
        Assertions.assertEquals(result.size(), 8);
    }

    @Test
    public void loadDentistNames() {
        ArrayList<Dentist> dentists = new ArrayList<>();
        Mockito.when(dentistRepository.findAll()).thenReturn(dentists);
        List<Dentist> result = dentistRepository.findAll();
        Mockito.verify(dentistRepository).findAll();
        Assertions.assertEquals(dentists, result);
    }
}
