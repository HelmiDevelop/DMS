
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.jpacontrollers;

import com.helmidev.entities.Billing;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

/**
 *
 * @author hoben
 */
public class BillingJpaController extends AbstractController<Billing> implements Serializable {

    public BillingJpaController() {
        super();
    }

    public Billing findBilling(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Billing.class, id);
        } finally {
            em.close();
        }
    }

    public List<Billing> findAllBillings() {
        EntityManager em = getEntityManager();
        try {
            List<Billing> billings = em.createNativeQuery("SELECT bil FROM Billing bil", Billing.class).getResultList();

            return billings;
        } finally {
            em.close();
        }
    }

    public int getBillingCount() {
        EntityManager em = getEntityManager();
        try {
            int count = (int) em.createNativeQuery("SELECT COUNT(bil) FROM Billing bil", int.class).getSingleResult();
            return count;

        } finally {
            em.close();
        }
    }

}
