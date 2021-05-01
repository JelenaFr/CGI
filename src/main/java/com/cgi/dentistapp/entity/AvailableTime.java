package com.cgi.dentistapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "available_times")
public class AvailableTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timePeriod;

    @OneToMany (mappedBy = "visitTime")
    private List<DentistVisitEntity> visitEntities;

    public AvailableTime(String timePeriod) {
        this.timePeriod = timePeriod;

    }
}
