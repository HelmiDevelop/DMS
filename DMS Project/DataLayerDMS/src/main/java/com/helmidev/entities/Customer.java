/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 *
 * @author Helmi Omrane
 */
@Entity
@Table(name = "tbl_customer")

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Vorname kann nicht NULL sein")
    @Size(min = 2, max = 55, message = "Vorname Länge darf nicht kürzer als 2 zeichen oder länger als 55 Zeichen")
    @Column(name = "customer_First_Name")
    private String first_name;
    @Size(min = 2, max = 55, message = "Nachname Länge darf nicht kürzer als 2 zeichen oder länger als 55 Zeichen")
    @NotNull(message = "Nachname kann nicht NULL sein ")
    @Column(name = "customer_Last_Name")
    private String last_name;
    @NotNull(message = "Email Adresse kann nicht NULL sein")   
    @Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$", message = "Bitte geben Sie eine gültige Email Adresse")
    @Column(name = "customer_Email", unique = true)
    private String email;
    @Column(name = "customer_Account")
    private double account;
    @OneToMany(mappedBy = "Customer",fetch = FetchType.EAGER)
    private List<Shopping> listOfShopping;
    @OneToMany(mappedBy = "Customer",fetch = FetchType.EAGER)
    private List<Billing> listOfBilling;

    public List<Shopping> getListOfShopping() {
        return listOfShopping;
    }

    public void setListOfShopping(List<Shopping> listOfShopping) {
        this.listOfShopping = listOfShopping;
    }

    public List<Billing> getListOfBilling() {
        return listOfBilling;
    }

    public void setListOfBilling(List<Billing> listOfBilling) {
        this.listOfBilling = listOfBilling;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public String getFullName(){
        return first_name +" "+last_name;
    }

    @Override
    public String toString() {
        return "Model.Entities.Customer[ id=" + id + " ]";
    }
    
}
