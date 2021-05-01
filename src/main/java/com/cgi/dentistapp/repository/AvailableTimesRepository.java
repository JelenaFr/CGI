package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.AvailableTime;
import com.cgi.dentistapp.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AvailableTimesRepository extends JpaRepository<AvailableTime, Long> {


    String allAvailable2 = "SELECT  AVAILABLE_TIMES FROM available_times RIGHT JOIN dentist_visit ON  " +
            "available_times.ID !=  dentist_visit.available_time_id WHERE dentist_id = :id and visit_date !=:visitDate";

    String allAvailable = "SELECT TIME_PERIOD FROM  available_times JOIN dentist_visit JOIN DENTIST_NAMES  ON dentist_visit.id=DENTIST_NAMES.id  WHERE dentist_id != :idT and visit_date != :visitDate";
    @Query(value = allAvailable, nativeQuery = true)
    List<AvailableTime> findByDentistAndVisitDate(@Param("idT") Long id, @Param("visitDate")String visitDate);


}
