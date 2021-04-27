package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.entity.Dentist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @Size(min = 1, max = 50)
    private List<Dentist> dentists;

    @NotNull(message = "Please enter birth date")
    @Future(message = "Visit date should be less than current date!!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Date visitTime;

    public DentistVisitDTO(List<Dentist> dentists, Date visitTime) {
        this.dentists = dentists;
        this.visitTime = visitTime;
    }
}
