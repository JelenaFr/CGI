package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.entity.Dentist;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DentistVisitDTO {

    Long id;
    private Dentist dentist;

    @NotNull(message = "Please enter birth date")
    @Future(message = "Visit date should be less than current date!!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Date visitTime;

    public DentistVisitDTO(Dentist dentist, Date visitTime) {
        this.dentist = dentist;
        this.visitTime = visitTime;
    }
}
