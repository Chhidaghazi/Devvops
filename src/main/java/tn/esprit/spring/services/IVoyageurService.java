package tn.esprit.spring.services;

import tn.esprit.spring.entities.Voyageur;

import java.util.List;


public interface IVoyageurService {
    Voyageur ajouterVoyageur(Voyageur Voyageur);
    //Modifier le voyageur
    Voyageur modifierVoyageur(Voyageur voyageur);
    List<Voyageur> recupererAll();
    Voyageur recupererVoyageParId(long idVoyageur);
    void supprimerVoyageur(Voyageur v);
}
