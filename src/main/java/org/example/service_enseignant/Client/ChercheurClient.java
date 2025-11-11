package org.example.service_enseignant.Client;

import org.example.service_enseignant.Configuration.FeignConfig;
import org.example.service_enseignant.Dto.ChercheurResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "chercheur-service", url = "http://localhost:8082", configuration = FeignConfig.class)
public interface ChercheurClient {

    @ GetMapping("/v1/chercheurs/enseignant/{id}")
    List<ChercheurResponseDTO> getChercheursByEnseignant(@PathVariable("id") Long enseignantId);
}
