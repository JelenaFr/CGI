package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {



    List<Appointment> findAppointmentByDate (String date);
    List<Appointment> findAppointmentByDentistAndIsAvailableAndDate(String id, boolean b, String date);
    List<Appointment> findAppointmentByDentistNameAndIsAvailableAndDate(String id, boolean b, String date);
    List<Appointment> findAppointmentByIsAvailable(boolean b);
    Appointment findAppointmentById (Long id);

}
