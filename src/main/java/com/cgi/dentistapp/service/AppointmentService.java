package com.cgi.dentistapp.service;

import com.cgi.dentistapp.dto.AppointmentDto;
import com.cgi.dentistapp.dto.AppointmentRequest;
import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.AppointmentRepository;
import com.cgi.dentistapp.repository.DentistRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@Service
@Transactional
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DentistRepository dentistRepository;
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void updateAppointment(AppointmentRequest request) {
        final val appointment = appointmentRepository.findAppointmentById(request.getId());
        appointment.setIsAvailable(false);
        appointmentRepository.save(appointment);
    }

    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAppointmentByIsAvailable(false);
    }

    public void setAvailableById(Long id) {
        appointmentRepository.setAppointmentAvailable(id);
    }

    public List<Appointment> createSchedule(Dentist dentist, LocalDate date) {
        String[] timesArr = {"09:00 - 09:40", "10:00 - 10:40", "11:00 - 11:40", "12:00 - 12:40", "13:00 - 13:40", "15:00 - 15:40", "16:00 - 16:40", "17:00 - 17:40"};
        List<Appointment> appointments = new ArrayList();
        for (String s : timesArr) {
            Appointment appointment = new Appointment();
            appointment.setDentist(dentist);
            appointment.setDate(date);
            appointment.setIsAvailable(true);
            appointment.setPeriod(s);
            appointments.add(appointmentRepository.save(appointment));
        }
        return appointments;
    }

    public List<Dentist> loadDentistNames() {
        return dentistRepository.findAll();
    }

    public List<AppointmentDto> getAppointmentDetails(Long id, String visitDateString) {
        LocalDate visitDate = parseDate(visitDateString);
        Dentist dentist = dentistRepository.findDentistsById(id);
        List<Appointment> appointments = new ArrayList<>();
        boolean isDentistAvailable = !appointmentRepository.findAppointmentByDateAndDentist(visitDate, dentist).isEmpty();
        if (isDentistAvailable) {
            appointments = appointmentRepository
                .findAppointmentByDentistAndIsAvailableAndDate(dentist, true, visitDate);
        } else {
            appointments = createSchedule(dentist, visitDate);
        }
        return appointments.stream()
            .map(appointment -> new AppointmentDto(appointment.getPeriod(), appointment.getId()))
            .collect(Collectors.toList());
    }

    private LocalDate parseDate(String date) {
        return LocalDate.parse(date, formatter);
    }
}
