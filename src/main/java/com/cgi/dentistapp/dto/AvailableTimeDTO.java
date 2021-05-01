package com.cgi.dentistapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AvailableTimeDTO {

    private Long id;
//    @NotNull(message = "Palun vali kellaeeg!")
    private String timePeriod;

}
