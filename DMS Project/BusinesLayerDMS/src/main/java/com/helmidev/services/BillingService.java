/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.services;

import com.helmidev.entities.Billing;
import com.helmidev.entities.Customer;
import com.helmidev.jpacontrollers.BillingJpaController;
import com.helmidev.jpacontrollers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hoben
 */
public class BillingService {

    private final BillingJpaController BillingJpa;

    public BillingService() {
        BillingJpa = new BillingJpaController();
    }

    public Billing addBilling(Billing billing) throws Exception {
        try {
            if (this.validateBilling(billing)) {
                return BillingJpa.create(billing);
            }
        } catch (Exception e) {
            throw e;
        }

        return null;
    }

    public void updateBilling(Billing billing) throws Exception {
        this.validateBilling(billing);
        BillingJpa.update(billing);
    }

    public void removeBilling(Billing billing) throws NonexistentEntityException {
        BillingJpa.destroy(billing);
    }

    public List<Billing> getAllBillings() {
        return BillingJpa.findAllBillings();
    }

    public List<Billing> findBillingByDate(Date date) {
        return getAllBillings().stream()
                .filter(pred -> pred.getBilling_Date()  == date)
                .collect(Collectors.toList());        
    }

    public List<Billing> findBillingByCustomer(Customer customer) {
        List<Billing> listOfBillingByCustomer = new ArrayList<>();
        int i = 0;
        for (Billing billing : getAllBillings()) {
            if (billing.getCustomer().equals(customer)) {
                listOfBillingByCustomer.add(billing);
                i++;
            }
        }
        return listOfBillingByCustomer;
    }

    private boolean validateBilling(Billing billing) {

        if (billing != null) {
            if (billing.getCustomer() != null) {
                return true;
            }
        }

        return false;

    }

}
