/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Helmi Omrane
 */
@Entity
@Table(name = "tbl_billing")
@XmlRootElement



public class Billing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "billing_Name")
    private String billing_Name;
    @Column(name = "billing_Date")
    @Temporal(TemporalType.DATE)
    private Date billing_Date;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Billing")
    private List<BillingDetails> billingDetails;
    @Column(name = "billing_Amount")
    private double billing_Amount;
    @ManyToOne(optional = false)
    @JoinColumns( {@JoinColumn(name = "customer_First_Name"),@JoinColumn(name = "customer_Last_Name"),@JoinColumn(name = "customer_Email")})
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBilling_Name() {
        return billing_Name;
    }

    public void setBilling_Name(String billing_Name) {
        this.billing_Name = billing_Name;
    }

    public Date getBilling_Date() {
        return billing_Date;
    }

    public void setBilling_Date(Date billing_Date) {
        this.billing_Date = billing_Date;
    }

    public List<BillingDetails> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(List<BillingDetails> billingDetails) {
        this.billingDetails = billingDetails;
    }

    public double getBilling_Amount() {
        return billing_Amount;
    }

    public void setBilling_Amount(double billing_Amount) {
        this.billing_Amount = billing_Amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    

    
    
    

    
}
