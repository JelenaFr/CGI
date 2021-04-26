package com.cgi.dentistapp.service;

import com.cgi.dentistapp.converter.EntityConverter;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.DentistVisitRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Data
@Service
@Transactional
public class DentistVisitService {
    @Autowired
    private DentistVisitRepository dentistVisitRepository;
    @Autowired
    private EntityConverter entityConverter;

    public void addVisit(String dentistName, Date visitTime) {
        DentistVisitDTO dentistVisitDTO = new DentistVisitDTO(dentistName, visitTime);
        DentistVisitEntity dentistVisitEntity = entityConverter.dtoToEntity(dentistVisitDTO);
        dentistVisitRepository.save(dentistVisitEntity);
        //TODO implementation
    }


    public Iterable<DentistVisitDTO> findAllAppointments() {
        List<DentistVisitEntity> dentistVisitEntityList = dentistVisitRepository.findAll();
        return entityConverter.entityToDto(dentistVisitEntityList);
    }


}
