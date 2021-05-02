package com.cgi.dentistapp;

import com.cgi.dentistapp.entity.Appointment;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.AppointmentRepository;
import com.cgi.dentistapp.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DentistAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(DentistAppApplication.class, args);
    }


    //@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DentistAppApplication.class);
    }



    @Autowired
    AppointmentRepository appointmentRepository;



    public Dentist createDentist(String name, DentistRepository dentistRepository) {
        Dentist dentist = new Dentist();
        dentist.setName(name);

        return dentistRepository.save(dentist);
    }

    public Appointment createTime(String period, Boolean isAvailable, AppointmentRepository appointmentRepository) {
        Appointment appointment = new Appointment();
        appointment.setPeriod(period);
        appointment.setIsAvailable(isAvailable);
        return appointmentRepository.save(appointment);
    }
    public

    @Bean
    CommandLineRunner runner(DentistRepository dentistRepository) {
        return args -> {
            Dentist doctor1 = createDentist("Priit Reedik", dentistRepository);
            Dentist doctor2 = createDentist("Juri Stukolkin", dentistRepository);
            Dentist doctor3 = createDentist("Andre Trudnikov", dentistRepository);
            Dentist doctor4 = createDentist("Arkadi Popov", dentistRepository);
            Dentist doctor5 = createDentist("Mari-Liis Toome", dentistRepository);
            Dentist doctor6 = createDentist("Urve Õim", dentistRepository);

        };
    }
}
