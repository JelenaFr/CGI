package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.entity.AvailableTime;
import com.cgi.dentistapp.entity.Dentist;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;



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
    private LocalDate visitDate;
    private AvailableTime visitTime;
    private Boolean isAvailable;

    public DentistVisitDTO(Dentist dentist, LocalDate visitDate, AvailableTime visitTime, boolean isAvailable) {
        this.dentist = dentist;
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.isAvailable = isAvailable;
    }
}
