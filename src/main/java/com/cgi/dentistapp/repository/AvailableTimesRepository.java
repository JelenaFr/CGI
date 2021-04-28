package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.AvailableTime;
import com.cgi.dentistapp.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableTimesRepository extends JpaRepository<AvailableTime, Long> {
}
