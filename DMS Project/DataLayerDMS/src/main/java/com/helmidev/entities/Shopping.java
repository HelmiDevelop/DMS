/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "tbl_shopping")
@XmlRootElement


public class Shopping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "shopping_Name")
    private String shopping_Name;
    @Column(name = "shopping_Date")
    @Temporal(TemporalType.DATE)
    private Date shopping_Date;
    @Column(name = "shopping_Details")
    private String shopping_Details;
    @Column(name = "shopping_Amount")
    private double shopping_Amount;
    @ManyToOne(optional = true)
    @JoinColumns({@JoinColumn(name = "customer_First_Name"),@JoinColumn(name = "customer_Last_Name"),@JoinColumn(name = "customer_Email")})
    private Customer customer;
    @JoinColumn(name = "supplier_Name")
    @ManyToOne(optional = true)
    private Supplier supplier;
    @OneToMany(mappedBy = "Shopping",fetch = FetchType.EAGER)
    private List<Product> listOfProd;

    public String getShopping_Name() {
        return shopping_Name;
    }

    public void setShopping_Name(String shopping_Name) {
        this.shopping_Name = shopping_Name;
    }

    public Date getShopping_Date() {
        return shopping_Date;
    }

    public void setShopping_Date(Date shopping_Date) {
        this.shopping_Date = shopping_Date;
    }

    public String getShopping_Details() {
        return shopping_Details;
    }

    public void setShopping_Details(String shopping_Details) {
        this.shopping_Details = shopping_Details;
    }

    public double getShopping_Amount() {
        return shopping_Amount;
    }

    public void setShopping_Amount(double shopping_Amount) {
        this.shopping_Amount = shopping_Amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<Product> getListOfProd() {
        return listOfProd;
    }

    public void setListOfProd(List<Product> listOfProd) {
        this.listOfProd = listOfProd;
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
        if (!(object instanceof Shopping)) {
            return false;
        }
        Shopping other = (Shopping) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entities.Shopping[ id=" + id + " ]";
    }
    
}
