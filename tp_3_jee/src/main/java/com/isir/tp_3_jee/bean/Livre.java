package com.isir.tp_3_jee.bean;

import com.isir.tp_3_jee.DAO;

import java.sql.SQLException;

public class Livre {
    private String isbn;
    private String titre;
    private String auteur;
    private int nbrPage;
    public Livre(){}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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
    public void enregistrer() throws SQLException {
        try {


            DAO dao = new DAO();
            dao.LoidDriver();
            dao.getConnection();
            dao.saveLivre(isbn, titre, auteur, nbrPage);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
