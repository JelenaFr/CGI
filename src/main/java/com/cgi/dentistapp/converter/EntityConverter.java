package com.cgi.dentistapp.converter;

import com.cgi.dentistapp.dto.DentistVisitDTO;
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
        dentistVisitDTO.setIsAvailable(dentistVisitEntity.getIsAvailable());
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
        dentistVisitEntity.setIsAvailable (dentistVisitDTO.getIsAvailable());
        return dentistVisitEntity;
    }

    public List<DentistVisitEntity> dtoToEntity(List<DentistVisitDTO> dentistVisitDTOList) {
        return dentistVisitDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }

}
