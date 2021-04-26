package com.cgi.dentistapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DentistVisitDTO {

    @Size(min = 1, max = 50)
    String dentistName;

    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    Date visitTime;


}
