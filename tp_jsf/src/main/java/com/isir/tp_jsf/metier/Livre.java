package com.isir.tp_jsf.metier;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Livre {
    @Id
    private int isbn;
    private String titre;
    private String auteur;
    private int nbrPage;
    public Livre(){}
    public Livre(int isbn, String titre, String auteur, int pages){
        this.isbn = isbn;
        this.auteur = auteur;
        this.titre = titre;
        this.nbrPage = pages;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String autheur) {
        this.auteur = autheur;
    }

    public int getNbrPage() {
        return nbrPage;
    }

    public void setNbrPage(int nbrPage) {
        this.nbrPage = nbrPage;
    }
}
