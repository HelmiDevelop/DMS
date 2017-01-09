/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Helmi Omrane
 */
@Entity
@Table(name = "tbl_packaging")

public class Packaging implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "packaging_Name", unique = true)
    @Basic(optional = false)
    private String pack_Name;
    @Column(name = "packaging_Description")
    private String pack_Description;
    @Column(name = "packaging_Size")
    private int pack_Size;
    @Column(name = "packaging_PurschasePrice")
    private double pack_Price;
    @Column(name = "packaging_IsPledge")
    private boolean pack_IsPledge;
    @Column(name = "packaging_PledgeValue")
    private double pack_PledgeValue;
    @Column(name = "packaging_BoxPledgeValue")
    private double pack_Box_Pledge_Value;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Packaging")
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    

    public String getPack_Name() {
        return pack_Name;
    }

    public void setPack_Name(String pack_Name) {
        this.pack_Name = pack_Name;
    }

    public String getPack_Description() {
        return pack_Description;
    }

    public void setPack_Description(String pack_Description) {
        this.pack_Description = pack_Description;
    }

    public int getPack_Size() {
        return pack_Size;
    }

    public void setPack_Size(int pack_Size) {
        this.pack_Size = pack_Size;
    }

    public double getPack_Price() {
        return pack_Price;
    }

    public void setPack_Price(double pack_Price) {
        this.pack_Price = pack_Price;
    }

    public boolean isPack_IsPledge() {
        return pack_IsPledge;
    }

    public void setPack_IsPledge(boolean pack_IsPledge) {
        this.pack_IsPledge = pack_IsPledge;
    }

    public double getPack_PledgeValue() {
        return pack_PledgeValue;
    }

    public void setPack_PledgeValue(double pack_PledgeValue) {
        this.pack_PledgeValue = pack_PledgeValue;
    }

    public double getPack_Box_Pledge_Value() {
        return pack_Box_Pledge_Value;
    }

    public void setPack_Box_Pledge_Value(double pack_Box_Pledge_Value) {
        this.pack_Box_Pledge_Value = pack_Box_Pledge_Value;
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
        if (!(object instanceof Packaging)) {
            return false;
        }
        Packaging other = (Packaging) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Packaging[ id=" + id + " ]";
    }
    
}
