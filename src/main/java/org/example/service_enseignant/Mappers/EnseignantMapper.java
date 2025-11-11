package org.example.service_enseignant.Mappers;

import org.example.service_enseignant.Dto.EnseignantRequestDTO;
import org.example.service_enseignant.Dto.EnseignantResponseDTO;
import org.example.service_enseignant.Entity.Enseignant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EnseignantMapper {

    public Enseignant DTO_TO_ENTITY(EnseignantRequestDTO enseignantRequestDTO) {
        Enseignant enseignant = new Enseignant();
        BeanUtils.copyProperties(enseignantRequestDTO, enseignant);
        return enseignant;
    }

    public EnseignantResponseDTO ENTITY_TO_DTO(Enseignant enseignant) {
        EnseignantResponseDTO responseDTO = new EnseignantResponseDTO();
        BeanUtils.copyProperties(enseignant, responseDTO);
        return responseDTO;
    }
}
