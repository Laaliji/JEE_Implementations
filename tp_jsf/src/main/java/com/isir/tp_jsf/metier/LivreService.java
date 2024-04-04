package com.isir.tp_jsf.metier;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class LivreService {
    @PersistenceContext
    EntityManager em;
    Livre livre;
    public LivreService() {
        em = Persistence.createEntityManagerFactory("biblio_tp5").createEntityManager();
    }
    public String enregistrerLivre() {
        em.persist(livre);
        return "livres";
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public List<Livre> tousLesLivres(){
        Query query = em.createQuery("select l from Livre l") ;
        List<Livre> lst = query.getResultList() ;
        return lst;
    }
}
