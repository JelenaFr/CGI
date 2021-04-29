package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.AvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AvailableTimesRepository extends JpaRepository<AvailableTime, Long> {


//    String allAvailable = "SELECT  * FROM AVAILABLE_TIMES RIGHT JOIN   DENTIST_VISIT ON  " +
//            "AVAILABLE_TIMES.ID =  DENTIST_VISIT.AVAILABLE_time_id WHERE DENTIST_ID = :id and visit_date like %:visit_date%";
//    @Query(value = allAvailable, nativeQuery = true)
//    List<AvailableTime> findByDentistAndVisitDate(@Param("id") Long id, @Param("visit_date") Date visitDate);

    List<AvailableTime> findAllAvailable();
//
//    List<AvailableTime>  findByDentistAndVisitDate(Dentist dentist, Date visitDate);


}
