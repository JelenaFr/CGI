package com.cgi.dentistapp;

import com.cgi.dentistapp.entity.AvailableTime;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.AvailableTimesRepository;
import com.cgi.dentistapp.repository.DentistNamesRepository;
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


    public Dentist createDentist(String name, DentistNamesRepository dentistNamesRepository) {
        Dentist dentist = new Dentist();
        dentist.setName(name);

        return dentistNamesRepository.save(dentist);
    }

    public AvailableTime createTime(String timePeriod, AvailableTimesRepository availableTimesRepository) {
        AvailableTime time = new AvailableTime();
        time.setTimePeriod(timePeriod);


        return availableTimesRepository.save(time);
    }

    @Bean
    CommandLineRunner runner(DentistNamesRepository dentistNamesRepository, AvailableTimesRepository availableTimesRepository) {
        return args -> {
            Dentist doctor1 = createDentist("Priit Reedik", dentistNamesRepository);
            Dentist doctor2 = createDentist("Juri Stukolkin", dentistNamesRepository);
            Dentist doctor3 = createDentist("Andre Trudnikov", dentistNamesRepository);
            Dentist doctor4 = createDentist("Arkadi Popov", dentistNamesRepository);
            Dentist doctor5 = createDentist("Mari-Liis Toome", dentistNamesRepository);
            Dentist doctor6 = createDentist("Urve Õim", dentistNamesRepository);

            AvailableTime time1 = createTime("09:00 - 09:40", availableTimesRepository);
            AvailableTime time2 = createTime("10:00 - 10:40", availableTimesRepository);
            AvailableTime time3 = createTime("11:00 - 11:40", availableTimesRepository);
            AvailableTime time4 = createTime("12:00 - 12:40", availableTimesRepository);
            AvailableTime time5 = createTime("13:00 - 13:40", availableTimesRepository);
            AvailableTime time6 = createTime("15:00 - 15:40", availableTimesRepository);
            AvailableTime time7 = createTime("16:00 - 16:40", availableTimesRepository);
            AvailableTime time8 = createTime("17:00 - 17:40", availableTimesRepository);


        };
    }
}
