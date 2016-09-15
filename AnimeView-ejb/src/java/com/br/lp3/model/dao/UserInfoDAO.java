/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.UserInfo;
import com.sun.javafx.print.Units;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author 31517072
 */
@Stateful
@LocalBean
public class UserInfoDAO implements GenericDAO<UserInfo> {

    @PersistenceContext(unitName = "AnimeView-ejbPU", type = PersistenceContextType.TRANSACTION)

    private EntityManager em;

    @Override
    public void create(UserInfo e) {
        em.persist(e);
    }

    @Override
    public void delete(UserInfo e) {
    em.merge(e);
    em.remove(e);
    }

    @Override
    public void update(UserInfo e) {
        em.merge(e);
    }

    @Override
    public List<UserInfo> read() {
        Query query = em.createNamedQuery("UserInfo.findAll");
        return query.getResultList();
    }

    @Override
    public UserInfo readById(long id) {
        // Eager
        return em.find(UserInfo.class, id);
   }

}
