package com.cgi.dentistapp.converter;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityConverter {


   public  DentistVisitDTO  entityToDto (DentistVisitEntity dentistVisitEntity){
       DentistVisitDTO dentistVisitDTO = new DentistVisitDTO();
       dentistVisitDTO.setId(dentistVisitEntity.getId());
       dentistVisitDTO.setDentists(dentistVisitEntity.getDentists());
       dentistVisitDTO.setVisitTime(dentistVisitEntity.getVisitTime());
       return dentistVisitDTO;
   }

   public List<DentistVisitDTO> entityToDto (List<DentistVisitEntity> dentistVisitEntityList){
       return dentistVisitEntityList.stream().map(x-> entityToDto(x)).collect(Collectors.toList());


   }
   public DentistVisitEntity dtoToEntity (DentistVisitDTO dentistVisitDTO) {
       DentistVisitEntity dentistVisitEntity = new DentistVisitEntity();
       dentistVisitEntity.setId(dentistVisitDTO.getId());
       dentistVisitEntity.setDentists(dentistVisitDTO.getDentists());
       dentistVisitEntity.setVisitTime(dentistVisitDTO.getVisitTime());
       return dentistVisitEntity;
   }
    public List<DentistVisitEntity> dtoToEntity (List<DentistVisitDTO> dentistVisitDTOList ){
        return dentistVisitDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }

}
