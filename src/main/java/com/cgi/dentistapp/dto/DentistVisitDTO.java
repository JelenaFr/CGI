package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.entity.AvailableTime;
import com.cgi.dentistapp.entity.Dentist;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DentistVisitDTO {

    Long id;
    private Dentist dentist;

//    @NotNull(message = "Please enter visit date")
    @Temporal(TemporalType.DATE)
//    @Future(message = "Visit date should be less than current date!!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date visitDate;
    private AvailableTime visitTime;


    public DentistVisitDTO(Dentist dentist, Date visitDate, AvailableTime visitTime) {
        this.dentist = dentist;
        this.visitDate = visitDate;
        this.visitTime = visitTime;

    }


}

//    @DateTimeFormat(pattern = "dd.MM.yyyy")
//    Date visitTime;
