/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.UserAnime;
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
public class UserAnimeDAO implements GenericDAO<UserAnime> {

    @PersistenceContext(unitName = "AnimeView-ejbPU", type = PersistenceContextType.TRANSACTION)

    private EntityManager em;

    @Override
    public void create(UserAnime e) {
        em.persist(e);
    }

    @Override
    public void delete(UserAnime e) {
    em.merge(e);
    em.remove(e);
    }

    @Override
    public void update(UserAnime e) {
        em.merge(e);
    }

    @Override
    public List<UserAnime> read() {
        Query query = em.createNamedQuery("UserAnime.findAll");
        return query.getResultList();
    }

    @Override
    public UserAnime readById(long id) {
        // Eager
        return em.find(UserAnime.class, id);
   }
    
    public UserAnime readByUsername(String username){
        Query query = em.createNamedQuery("UserAnime.findByUsername")
                .setParameter("username", username);
        Object object = null;
        try {
            object = query.getSingleResult();
            return (UserAnime)object;
        } catch (NoResultException ex) {
            return null;
        }
    }
    public UserAnime readByEmail(String email){
        Query query = em.createNamedQuery("UserInfo.findByEmail")
                .setParameter("email", email);
        Object object = null;
        try {
            object = query.getSingleResult();
            return (UserAnime)object;
        } catch (NoResultException ex) {
            return null;
        }
    }

}
