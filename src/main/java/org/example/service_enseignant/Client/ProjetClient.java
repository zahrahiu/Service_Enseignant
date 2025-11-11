package org.example.service_enseignant.Client;

import org.example.service_enseignant.Configuration.FeignConfig;
import org.example.service_enseignant.Dto.ProjetResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-projet", url = "http://localhost:8083")
public interface ProjetClient {
    @GetMapping("/v1/projets/enseignant/{enseignantId}")
    List<ProjetResponseDTO> getProjetsByEnseignant(@PathVariable("enseignantId") Long enseignantId);
}
