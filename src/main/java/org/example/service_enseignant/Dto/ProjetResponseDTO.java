package org.example.service_enseignant.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjetResponseDTO {
    private Long id;
    private String titre;
    private String description;
    private Long chercheurId;
    private Long enseignantId;
}