package com.cgi.dentistapp.dto;

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
public class AppointmentDTO {

    Long id;
    @NotNull(message = "Palun vali hambaarsti nimi!")
    private Dentist dentist;
    @NotEmpty(message = "Palun vali kuupäev!")
    private String date;
    @NotNull(message = "Palun vali kellaeeg!")
    private String period;
    private Boolean isAvailable;


    public AppointmentDTO(Dentist dentist, String date, String period) {
        this.dentist = dentist;
        this.date = date;
        this.period = period;

    }

    public AppointmentDTO(Dentist dentist, String date, String period, Boolean isAvailable) {
        this.dentist = dentist;
        this.date = date;
        this.period = period;
        this.isAvailable = isAvailable;
    }
}

