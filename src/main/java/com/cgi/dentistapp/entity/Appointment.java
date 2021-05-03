package com.cgi.dentistapp.entity;

import com.cgi.dentistapp.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    private String date;
    private String period;
    private Boolean isAvailable;

    public Appointment(Dentist dentist, String date, String period, Boolean isAvailable) {
        this.dentist = dentist;
        this.date = date;
        this.period = period;
        this.isAvailable = isAvailable;
    }

}
