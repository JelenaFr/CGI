package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.entity.Dentist;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long> {

    List<Appointment> findAppointmentByDateAndDentist(LocalDate date, Dentist dentist);

    List<Appointment> findAppointmentByDentistAndIsAvailableAndDate(Dentist dentist, boolean available, LocalDate date);

    List<Appointment> findAppointmentByIsAvailable(boolean b);

    Appointment findAppointmentById(Long id);

    @Modifying
    @Query("update Appointment appointment set appointment.isAvailable = true where appointment.id=:id")
    void setAppointmentAvailable(@Param("id") Long id);
}
