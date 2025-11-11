package org.example.service_enseignant.Dto;


import lombok.Data;

@Data
public class EnseignantRequestDTO {
    private String nom;
    private String prenom;
    private String CNE;
    private String email;
    private String motDePasse;
    private String thematique;
}
