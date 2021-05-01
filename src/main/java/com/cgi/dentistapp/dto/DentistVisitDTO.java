package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.entity.AvailableTime;
import com.cgi.dentistapp.entity.Dentist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DentistVisitDTO {

    Long id;
    @NotNull(message = "Palun vali hambaarsti nimi!")
    private Dentist dentist;
    @NotEmpty(message = "Palun vali kuupäev!")
    private String visitDate;
    @NotNull(message = "Palun vali kellaeeg!")
    private AvailableTime visitTime;


    public DentistVisitDTO(Dentist dentist, String visitDate, AvailableTime visitTime) {
        this.dentist = dentist;
        this.visitDate = visitDate;
        this.visitTime = visitTime;

    }

}

