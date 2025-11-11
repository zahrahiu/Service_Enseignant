package org.example.service_enseignant.Controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.example.service_enseignant.Dto.EnseignantRequestDTO;
import org.example.service_enseignant.Dto.EnseignantResponseDTO;
import org.example.service_enseignant.Dto.StatsResponseDTO;
import org.example.service_enseignant.Service.EnseignantService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Service des enseignants",
                description = "Ce service permet de gérer les enseignants du laboratoire.",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8081"
        )
)
@RestController
@RequestMapping("/v1/enseignants")
public class EnseignantController {

    private final EnseignantService service;

    public EnseignantController(EnseignantService service) {
        this.service = service;
    }

    // ===================== CRUD Enseignant =====================
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping
    public ResponseEntity<EnseignantResponseDTO> createEnseignant(@RequestBody EnseignantRequestDTO dto) {
        EnseignantResponseDTO response = service.createEnseignant(dto);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<EnseignantResponseDTO> updateEnseignant(@PathVariable Long id,
                                                                  @RequestBody EnseignantRequestDTO dto) {
        EnseignantResponseDTO response = service.updateEnseignant(id, dto);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnseignant(@PathVariable Long id) {
        service.deleteEnseignant(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping
    public ResponseEntity<List<EnseignantResponseDTO>> getAllEnseignants() {
        List<EnseignantResponseDTO> enseignants = service.getAllEnseignants();
        return ResponseEntity.ok(enseignants);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<EnseignantResponseDTO> getEnseignantById(@PathVariable Long id) {
        EnseignantResponseDTO response = service.getEnseignantById(id);
        return ResponseEntity.ok(response);
    }

    // ===================== Endpoint pour Stats (liaison avec Chercheurs et Projets) =====================
    @Operation(summary = "Consulter statistiques (nombre de chercheurs/projets encadrés)",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Statistiques récupérées",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = StatsResponseDTO.class))),
                    @ApiResponse(responseCode = "4xx", description = "Erreur client"),
                    @ApiResponse(responseCode = "5xx", description = "Erreur serveur")
            })
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping("/{id}/stats")
    public ResponseEntity<StatsResponseDTO> getStats(@PathVariable Long id) {
        StatsResponseDTO stats = service.getStats(id);
        return ResponseEntity.ok(stats);
    }
}
