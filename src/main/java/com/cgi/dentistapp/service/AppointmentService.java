package com.cgi.dentistapp.service;

import com.cgi.dentistapp.converter.Converter;
import com.cgi.dentistapp.dto.AppointmentDTO;
import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.AppointmentRepository;
import com.cgi.dentistapp.repository.DentistRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

;

@Data
@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DentistRepository dentistRepository;




    public void addAppointment(Dentist dentist, String date, String period) {
        AppointmentDTO appointmentDTO = new AppointmentDTO(dentist, date, period);
        Appointment appointment = converter.dtoToEntity(appointmentDTO);
        appointmentRepository.save(appointment);

    }

    public void updateAppointment (Appointment appointmentB){

        Appointment appointmentR = appointmentRepository.findAppointmentById(appointmentB.getId());
        appointmentR.setDate(appointmentB.getDate());
        appointmentR.setDentist(appointmentB.getDentist());
        appointmentR.setIsAvailable(appointmentB.getIsAvailable());
        appointmentR.setPeriod(appointmentB.getPeriod());

    }


    public Iterable<Appointment> findAllAppointments() {
        List<Appointment> appointmentList = appointmentRepository.findAppointmentByIsAvailable(false);
        return appointmentList;
    }

    public void deleteVisitById(Long id) {

        appointmentRepository.delete(id);
    }

    public AppointmentDTO findById(Long id) {
        return converter.entityToDto(appointmentRepository.findOne(id));
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
