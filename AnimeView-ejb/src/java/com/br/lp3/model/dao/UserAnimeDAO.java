/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Useranime;
import com.br.lp3.model.entities.Userinfo;
import com.sun.javafx.print.Units;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author 31517072
 */
@Stateful
@LocalBean
public class UserAnimeDAO implements GenericDAO<Useranime> {

    @PersistenceContext(unitName = "AnimeView-ejbPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void create(Useranime e) {
        em.persist(e);
    }

    @Override
    public void delete(Useranime e) {
    em.merge(e);
    em.remove(e);
    }

    @Override
    public void update(Useranime e) {
        em.merge(e);
    }

    @Override
    public List<Useranime> read() {
        Query query = em.createNamedQuery("Useranime.findAll");
        return (List<Useranime>)query.getResultList();
    }

    @Override
    public Useranime readById(long id) {
        // Eager
        return em.find(Useranime.class, id);
   }
    
    public Useranime readByUsername(String username) {
        Query query = em.createNamedQuery("Useranime.findByUsername")
                .setParameter("username", username);
        Object object = null;
        try {
            object = query.getSingleResult();
            return (Useranime)object;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public Useranime readByEmail(String email) {
        Query query = em.createNamedQuery("Userinfo.findByEmail")
                .setParameter("email", email);
        Object object = null;
        try {
            object = query.getSingleResult();
            return ((Userinfo)object).getUseranime();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
