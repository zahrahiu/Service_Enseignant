package org.example.service_enseignant.Service;


import org.example.service_enseignant.Dto.EnseignantRequestDTO;
import org.example.service_enseignant.Dto.EnseignantResponseDTO;
import org.example.service_enseignant.Dto.StatsResponseDTO;

import java.util.List;

public interface EnseignantService {

    EnseignantResponseDTO createEnseignant(EnseignantRequestDTO dto);

    EnseignantResponseDTO updateEnseignant(Long id, EnseignantRequestDTO dto);

    void deleteEnseignant(Long id);

    List<EnseignantResponseDTO> getAllEnseignants();

    EnseignantResponseDTO getEnseignantById(Long id);

    StatsResponseDTO getStats(Long id);
}
