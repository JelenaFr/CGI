//package com.cgi.dentistapp.converter;
//
//import com.cgi.dentistapp.dto.AppointmentDTO;
//import com.cgi.dentistapp.entity.Appointment;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class Converter {
//
//
//    public AppointmentDTO entityToDto(Appointment appointment) {
//        AppointmentDTO appointmentDTO = new AppointmentDTO();
//        appointmentDTO.setId(appointment.getId());
//        appointmentDTO.setDentist(appointment.getDentist());
//        appointmentDTO.setDate(appointment.getDate());
//        appointmentDTO.setPeriod(appointment.getPeriod());
//
//        return appointmentDTO;
//    }
//
//    public List<AppointmentDTO> entityToDto(List<Appointment> appointmentList) {
//        return appointmentList.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
//    }
//
//    public Appointment dtoToEntity(AppointmentDTO appointmentDTO) {
//        Appointment appointment = new Appointment();
//        appointment.setId(appointmentDTO.getId());
//        appointment.setDentist(appointmentDTO.getDentist());
//        appointment.setDate(appointmentDTO.getDate());
//        appointment.setPeriod(appointmentDTO.getPeriod());
//        appointment.setIsAvailable(appointment.getIsAvailable());
//        return appointment;
//    }
//
//    public List<Appointment> dtoToEntity(List<AppointmentDTO> appointmentDTOList) {
//        return appointmentDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
//
//    }
//
//
//
//
//}
