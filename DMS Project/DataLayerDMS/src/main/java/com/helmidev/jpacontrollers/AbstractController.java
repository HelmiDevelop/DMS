/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.jpacontrollers;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author hoben
 * @param <T>
 */
public abstract class AbstractController<T> {

    protected EntityManagerFactory emf;

    public AbstractController() {
        emf = Persistence.createEntityManagerFactory("DMSPU");
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public T create(T entity) throws Exception {
        EntityManager em = getEntityManager();
        try {
            String msg = "";
            EntityTransaction tx = em.getTransaction();
            /*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<T>> constraints = validator
                    .validate(entity);

            if (!constraints.isEmpty()) {
                for (ConstraintViolation cons : constraints) {
                    msg += cons.getMessage() + "\n";
                }
                throw new Exception(msg);
            }*/
            tx.begin();
            if (!em.contains(entity)) {
                em.persist(entity);
                tx.commit();
            }

            //em.flush();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return entity;
    }

    public T update(T entity) throws Exception {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            em.flush();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return entity;
    }

    public void destroy(T entity) {
        EntityManager em = getEntityManager();
        T current = null;
        try {
            em.getTransaction().begin();
            if (!em.contains(entity)){
               current = em.merge(entity);
            }
            em.remove(current);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
