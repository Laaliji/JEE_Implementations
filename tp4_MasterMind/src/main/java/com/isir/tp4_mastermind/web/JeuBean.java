package com.isir.tp4_mastermind.web;

import java.util.ArrayList;

public class JeuBean {
    private int nbr;

    private ArrayList<String> lstMessages;

    public JeuBean() {
        lstMessages = new ArrayList<String>();
    }

    public ArrayList<String> getLstMessages() {
        return lstMessages;
    }

    public void setLstMessages(ArrayList<String> lstMessages) {
        this.lstMessages = lstMessages;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }
}
