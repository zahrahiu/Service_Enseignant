package org.example.service_enseignant.Service;

import org.example.service_enseignant.Client.ChercheurClient;
import org.example.service_enseignant.Client.ProjetClient;
import org.example.service_enseignant.Dto.*;
import org.example.service_enseignant.Entity.Enseignant;
import org.example.service_enseignant.Mappers.EnseignantMapper;
import org.example.service_enseignant.Repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnseignantServiceImpl implements EnseignantService {


    @Autowired
    private ChercheurClient chercheurClient;

    @Autowired
    private ProjetClient projetClient;

    @Autowired
    private EnseignantRepository repository;

    @Autowired
    private EnseignantMapper mapper;

    @Override
    public EnseignantResponseDTO createEnseignant(EnseignantRequestDTO dto) {
        Enseignant enseignant = mapper.DTO_TO_ENTITY(dto);
        Enseignant saved = repository.save(enseignant);
        return mapper.ENTITY_TO_DTO(saved);
    }

    @Override
    public EnseignantResponseDTO updateEnseignant(Long id, EnseignantRequestDTO dto) {
        Enseignant enseignant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé"));
        enseignant.setNom(dto.getNom());
        enseignant.setPrenom(dto.getPrenom());
        enseignant.setCNE(dto.getCNE());
        enseignant.setEmail(dto.getEmail());
        enseignant.setMotDePasse(dto.getMotDePasse());
        enseignant.setThematique(dto.getThematique());
        Enseignant updated = repository.save(enseignant);
        return mapper.ENTITY_TO_DTO(updated);
    }

    @Override
    public void deleteEnseignant(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<EnseignantResponseDTO> getAllEnseignants() {
        return repository.findAll()
                .stream()
                .map(mapper::ENTITY_TO_DTO)
                .collect(Collectors.toList());
    }

    @Override
    public EnseignantResponseDTO getEnseignantById(Long id) {
        Enseignant enseignant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé"));
        return mapper.ENTITY_TO_DTO(enseignant);
    }

    public StatsResponseDTO getStats(Long id) {
        List<ChercheurResponseDTO> chercheurs = chercheurClient.getChercheursByEnseignant(id);
        List<ProjetResponseDTO> projets = projetClient.getProjetsByEnseignant(id);
        return new StatsResponseDTO(chercheurs.size(), projets.size());
    }

}
