package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.AppointmentRepository;
import com.cgi.dentistapp.repository.DentistRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



@Data
@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DentistRepository dentistRepository;


    public void addAppointment(Dentist dentist, String date, String period, Boolean isAvailable) {
        appointmentRepository.save(new Appointment(dentist, date, period, isAvailable));

    }

    public void updateAppointment(Appointment appointment) {
        appointment.setIsAvailable(false);
        appointmentRepository.save(appointment);
    }


    public Iterable<Appointment> findAllAppointments() {
        return appointmentRepository.findAppointmentByIsAvailable(false);
    }

    public void deleteVisitById(Long id) {
       appointmentRepository.findAppointmentById(id);
        //appointmentRepository.delete(id);
    }

    public Appointment findById(Long id) {
        return appointmentRepository.findAppointmentById(id);
    }

    public List<Dentist> loadDentistNames() {
        return dentistRepository.findAll();
    }


    public void createSchedule(Dentist dentist, String date) {
        String[] timesArr = {"09:00 - 09:40", "10:00 - 10:40", "11:00 - 11:40", "12:00 - 12:40", "13:00 - 13:40", "15:00 - 15:40", "16:00 - 16:40", "17:00 - 17:40"};

        for (String s : timesArr) {
            Appointment appointment = new Appointment();
            appointment.setDentist(dentist);
            appointment.setDate(date);
            appointment.setIsAvailable(true);
            appointment.setPeriod(s);
            appointmentRepository.save(appointment);
        }
    }
}
