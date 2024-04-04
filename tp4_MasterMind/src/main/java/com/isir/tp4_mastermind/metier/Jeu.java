package com.isir.tp4_mastermind.metier;

public class Jeu {
    private int nbrSecret;

    private boolean end;

    private int game;

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public void genererNbr() {
        nbrSecret = (int) (Math.random() * 10);
    }

    public String jouer(int nombrePropose) {
        if (nombrePropose == nbrSecret) {
            end = true;
            return "Bravo!! vous avez réussi";
        } else {
            if (nombrePropose > nbrSecret) {
                return "Entrer un nombre plus petit que " + nombrePropose;
            } else {
                return "Entrer un nombre plus grand que " + nombrePropose;
            }
        }
    }
    public void fermerJeu(){
        this.end = true;
    }

    public void lancerJeu(){
        this.end = false;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}