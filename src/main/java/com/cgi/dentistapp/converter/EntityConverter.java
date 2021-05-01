package com.cgi.dentistapp.converter;

import com.cgi.dentistapp.dto.AvailableTimeDTO;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.AvailableTime;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityConverter {


    public DentistVisitDTO entityToDto(DentistVisitEntity dentistVisitEntity) {
        DentistVisitDTO dentistVisitDTO = new DentistVisitDTO();
        dentistVisitDTO.setId(dentistVisitEntity.getId());
        dentistVisitDTO.setDentist(dentistVisitEntity.getDentist());
        dentistVisitDTO.setVisitDate(dentistVisitEntity.getVisitDate());
        dentistVisitDTO.setVisitTime(dentistVisitEntity.getVisitTime());

        return dentistVisitDTO;
    }

    public List<DentistVisitDTO> entityToDto(List<DentistVisitEntity> dentistVisitEntityList) {
        return dentistVisitEntityList.stream().map(x -> entityToDto(x)).collect(Collectors.toList());


    }

    public DentistVisitEntity dtoToEntity(DentistVisitDTO dentistVisitDTO) {
        DentistVisitEntity dentistVisitEntity = new DentistVisitEntity();
        dentistVisitEntity.setId(dentistVisitDTO.getId());
        dentistVisitEntity.setDentist(dentistVisitDTO.getDentist());
        dentistVisitEntity.setVisitDate(dentistVisitDTO.getVisitDate());
        dentistVisitEntity.setVisitTime(dentistVisitDTO.getVisitTime());

        return dentistVisitEntity;
    }

//    public List<DentistVisitEntity> dtoToEntity(List<DentistVisitDTO> dentistVisitDTOList) {
//        return dentistVisitDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
//
//    }


    public AvailableTimeDTO entityToDto2(AvailableTime availableTime) {
        AvailableTimeDTO availableTimeDTO = new AvailableTimeDTO();
        availableTimeDTO.setId(availableTime.getId());
        availableTimeDTO.setTimePeriod(availableTime.getTimePeriod());
        return availableTimeDTO;
    }

    public List<AvailableTimeDTO> entityToDto2(List<AvailableTime> availableTimeList) {
        return availableTimeList.stream().map(x -> entityToDto2(x)).collect(Collectors.toList());


    }

    public AvailableTime dtoToEntity2(AvailableTimeDTO availableTimeDTO) {
        AvailableTime availableTime = new AvailableTime();
        availableTime.setId(availableTimeDTO.getId());
        availableTime.setTimePeriod(availableTimeDTO.getTimePeriod());


        return availableTime;
    }

    public List<AvailableTime> dtoToEntity(List<AvailableTimeDTO> availableTimeDTOList) {
        return availableTimeDTOList.stream().map(x -> dtoToEntity2(x)).collect(Collectors.toList());

    }

}
