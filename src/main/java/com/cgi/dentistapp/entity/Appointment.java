package com.cgi.dentistapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate date;
    private String period;
    private Boolean isAvailable;

    public Appointment(Dentist dentist, LocalDate date, String period, Boolean isAvailable) {
        this.dentist = dentist;
        this.date = date;
        this.period = period;
        this.isAvailable = isAvailable;
    }

    public String getDateAsString() {
        return date.toString();
    }
}
