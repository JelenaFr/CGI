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

//    public Appointment (Dentist dentist, String date) {
//        String[] timesArr = {"09:00 - 09:40", "10:00 - 10:40", "11:00 - 11:40", "12:00 - 12:40", "13:00 - 13:40", "15:00 - 15:40", "16:00 - 16:40", "17:00 - 17:40"};
//        this.dentist = dentist;
//        this.date = date;
//        for (int i = 0; i < timesArr.length; i++) {
//            this.period = timesArr[i] ;
//        }
//        this.isAvailable = true;
//
//    }

    //    public Appointment(Dentist dentist, String date, String s, boolean b) {
//        Appointment appointment1 = new Appointment(dentist, date, "09:00 - 09:40", false);
//        Appointment appointment2 = new Appointment(dentist, date, "10:00 - 10:40", false);
//        Appointment appointment3 = new Appointment(dentist, date, "11:00 - 11:40", false);
//        Appointment appointment4 = new Appointment(dentist, date, "12:00 - 12:40", false);
//        Appointment appointment5 = new Appointment(dentist, date, "13:00 - 13:40", false);
//        Appointment appointment6 = new Appointment(dentist, date, "15:00 - 15:40", false);
//        Appointment appointment7 = new Appointment(dentist, date, "16:00 - 16:40", false);
//        Appointment appointment8 = new Appointment(dentist, date, "17:00 - 17:40", false);
//    }

//    public void createSchedule(Dentist dentist, String date) {
//        Appointment appointment1 = new Appointment(dentist, date, "09:00 - 09:40", false);
//        Appointment appointment2 = new Appointment(dentist, date, "10:00 - 10:40", false);
//        Appointment appointment3 = new Appointment(dentist, date, "11:00 - 11:40", false);
//        Appointment appointment4 = new Appointment(dentist, date, "12:00 - 12:40", false);
//        Appointment appointment5 = new Appointment(dentist, date, "13:00 - 13:40", false);
//        Appointment appointment6 = new Appointment(dentist, date, "15:00 - 15:40", false);
//        Appointment appointment7 = new Appointment(dentist, date, "16:00 - 16:40", false);
//        Appointment appointment8 = new Appointment(dentist, date, "17:00 - 17:40", false);
//
//    }
}
