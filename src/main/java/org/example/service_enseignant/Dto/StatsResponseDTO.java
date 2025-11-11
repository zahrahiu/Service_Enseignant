package org.example.service_enseignant.Dto;

public class StatsResponseDTO {
    private int nbChercheurs;
    private int nbProjets;

    public StatsResponseDTO() {}

    public StatsResponseDTO(int nbChercheurs, int nbProjets) {
        this.nbChercheurs = nbChercheurs;
        this.nbProjets = nbProjets;
    }

    public int getNbChercheurs() {
        return nbChercheurs;
    }

    public void setNbChercheurs(int nbChercheurs) {
        this.nbChercheurs = nbChercheurs;
    }

    public int getNbProjets() {
        return nbProjets;
    }

    public void setNbProjets(int nbProjets) {
        this.nbProjets = nbProjets;
    }
}
