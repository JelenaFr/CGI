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

//            Appointment time1 = createTime("09:00 - 09:40", true, appointmentRepository);
//            Appointment time2 = createTime("10:00 - 10:40", true, appointmentRepository);
//            Appointment time3 = createTime("11:00 - 11:40", true, appointmentRepository);
//            Appointment time4 = createTime("12:00 - 12:40", true, appointmentRepository);
//            Appointment time5 = createTime("13:00 - 13:40", true, appointmentRepository);
//            Appointment time6 = createTime("15:00 - 15:40", true, appointmentRepository);
//            Appointment time7 = createTime("16:00 - 16:40", true, appointmentRepository);
//            Appointment time8 = createTime("17:00 - 17:40", true, appointmentRepository);
//            Appointment notAvailableTime1 = new Appointment(1L, doctor4, "15-05-2021", "09:00 - 09:40", false );
//            Appointment notAvailableTime2 = new Appointment(1L, doctor4, "16-05-2021", "10:00 - 11:40", false );
//            Appointment notAvailableTime3 = new Appointment(1L, doctor4, "15-05-2021", "11:00 - 11:40", false );
//            Appointment notAvailableTime4 = new Appointment(1L, doctor4, "18-05-2021", "12:00 - 11:40", false );
//            Appointment notAvailableTime5 = new Appointment(1L, doctor4, "25-05-2021", "13:00 - 11:40", false );
//            Appointment notAvailableTime6 = new Appointment(1L, doctor4, "26-05-2021", "15:00 - 11:40", false );
//            Appointment notAvailableTime7 = new Appointment(1L, doctor4, "19-05-2021", "16:00 - 11:40", false );
//            Appointment notAvailableTime7 = new Appointment(1L, doctor4, "19-05-2021", "17:00 - 11:40", false );
//            appointmentRepository.save(notAvailableTime1);


        };
    }
}
