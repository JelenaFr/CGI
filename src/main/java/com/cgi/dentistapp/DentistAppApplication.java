package com.cgi.dentistapp;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.DentistNamesRepository;
import com.cgi.dentistapp.repository.DentistVisitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class DentistAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(DentistAppApplication.class, args);
    }

//    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DentistAppApplication.class);
    }

    public Dentist createDentist(String name, DentistNamesRepository dentistNamesRepository) {
        Dentist dentist = new Dentist();
        dentist.setName(name);

        return dentistNamesRepository.save(dentist);
    }

    @Bean
    CommandLineRunner runner(DentistNamesRepository dentistNamesRepository) {
        return args -> {
            Dentist doctor1 = createDentist("Priit Reedik", dentistNamesRepository);
            Dentist doctor2 = createDentist("Juri Stukolkin", dentistNamesRepository);
            Dentist doctor3 = createDentist("Andre Trudnikov", dentistNamesRepository);
            Dentist doctor4 = createDentist("Arkadi Popov", dentistNamesRepository);
            Dentist doctor5 = createDentist("Mari-Liis Toome", dentistNamesRepository);
            Dentist doctor6 = createDentist("Urve Õim", dentistNamesRepository);


//            List<Dentist> categories1 = Arrays.asList(patientsPortal, microsoftSharePoint);
//            List<Dentist> categories2 = Arrays.asList(registration, doctorsPortal);
//
//            dentistVisitRepository.save(new DentistVisitEntity(1L,  doctor1,));
//            dentistVisitRepository.save(new DentistVisitEntity(2L, "Melania Trump", "trump@gmail.com", categories2, "one more text"));

        };
    }
}
