package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DentistRestAppControllerTest {

    @InjectMocks
    private DentistRestAppController controller;
    @Mock
    private AppointmentService appointmentService;

    @Test
    public void getDetails() {
        controller.getDetails(1L, "2022-12-12");
        Mockito.verify(appointmentService).getAppointmentDetails(1L, "2022-12-12");
    }

    @Test
    public void findAllAppointments() {
        controller.findAllAppointments();
        Mockito.verify(appointmentService).findAllAppointments();
    }

    @Test
    public void editAppointment() {
        controller.editAppointment(1L);
        Mockito.verify(appointmentService).setAvailableById(1L);
    }
}
