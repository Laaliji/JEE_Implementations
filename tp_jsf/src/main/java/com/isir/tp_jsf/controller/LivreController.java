package com.isir.tp_jsf.controller;

import com.isir.tp_jsf.metier.Livre;
import com.isir.tp_jsf.metier.LivreService;
import jakarta.ejb.EJB;

import java.util.List;

public class LivreController {

    @EJB
    private LivreService livreService;
    public String enregistrerLivre() {
        livreService.enregistrerLivre();
        livreService.setLivre(new Livre());
        return "livres";
    }
    public List<Livre> getAllLivres() {
        return livreService.tousLesLivres();
    }
}
