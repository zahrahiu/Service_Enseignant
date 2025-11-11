package org.example.service_enseignant.Dto;

import lombok.Data;

@Data
public class EnseignantResponseDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String CNE;
    private String email;
    private String thematique;
}
