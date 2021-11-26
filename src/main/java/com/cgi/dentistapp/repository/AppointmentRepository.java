package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.entity.Dentist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long> {

    List<Appointment> findAppointmentByDateAndDentist(String date, Dentist dentist);

    List<Appointment> findAppointmentByDentistAndIsAvailableAndDate(Dentist dentist, boolean available, String date);

    List<Appointment> findAppointmentByIsAvailable(boolean b);

    Appointment findAppointmentById(Long id);

    @Modifying
    @Query("update Appointment appointment set appointment.isAvailable = true where appointment.id=:id")
    void setTrue(@Param("id") Long id);


    List<Appointment> findAllByDentist (Dentist dentist, Pageable pageable);
    List<Appointment> findAllByDate (String date, Pageable pageable);
}
