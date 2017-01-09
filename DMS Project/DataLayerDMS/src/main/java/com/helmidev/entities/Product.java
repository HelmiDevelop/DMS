/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Helmi Omrane
 */
@Entity
@Table(name = "tbl_product")
@XmlRootElement

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "product_Name")
    private String product_Name;
    @Column(name = "product_Description")
    private String product_Description;
    @Column(name = "product_SellPrice")
    private double product_SellPrice;
    @Column(name = "product_PurschasePrice")
    private double product_PruschasePrice;
    @Column(name = "product_UnitSpan")
    private double product_UnitSpan;
    @Column(name = "product_IsPledge")
    private boolean product_IsPledge;
    @JoinColumn(name = "packaging_Name")
    @ManyToOne(optional = true , fetch = FetchType.EAGER)
    private Packaging packaging;
    @JoinColumn(name = "category_Name")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Category category;
    @ManyToOne(optional = true)
    private Shopping shopping;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Category getCategory() {
        return category;
    }

    public Shopping getShopping() {
        return shopping;
    }

    public Billing getBilling() {
        return billing;
    }
    @ManyToOne(optional = true)
    private Billing billing;

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getProduct_Description() {
        return product_Description;
    }

    public void setProduct_Description(String product_Description) {
        this.product_Description = product_Description;
    }

    public double getProduct_SellPrice() {
        return product_SellPrice;
    }

    public void setProduct_SellPrice(double product_SellPrice) {
        this.product_SellPrice = product_SellPrice;
    }

    public double getProduct_PruschasePrice() {
        return product_PruschasePrice;
    }

    public void setProduct_PruschasePrice(double product_PruschasePrice) {
        this.product_PruschasePrice = product_PruschasePrice;
    }

    public double getProduct_UnitSpan() {
        return product_UnitSpan;
    }

    public void setProduct_UnitSpan(double product_UnitSpan) {
        this.product_UnitSpan = product_UnitSpan;
    }

    public boolean isProduct_IsPledge() {
        return product_IsPledge;
    }

    public void setProduct_IsPledge(boolean product_IsPledge) {
        this.product_IsPledge = product_IsPledge;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entities.Product[ id=" + id + " ]";
    }
    
}
