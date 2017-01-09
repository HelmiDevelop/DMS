/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.services;

import com.helmidev.entities.Customer;
import com.helmidev.entities.Shopping;
import com.helmidev.entities.Supplier;
import com.helmidev.jpacontrollers.ShoppingJpaController;
import com.helmidev.jpacontrollers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author hoben
 */
public class ShoppingService {
    
    private final ShoppingJpaController shopJpa;

    public ShoppingService() {
        
        shopJpa = new ShoppingJpaController();
    }
    public void addShopping(Shopping shopping) throws Exception{
        try {
            shopJpa.create(shopping);
        } catch (Exception ex) {
            throw ex;
        }
    }
    public void updateShopping(Shopping shopping) throws Exception{
        shopJpa.update(shopping);
    }
    public void removeShopping(Shopping shopping) throws NonexistentEntityException{
        shopJpa.destroy(shopping);
    }
    
    public List<Shopping> getAllShoppings(){
        return shopJpa.findShoppingEntities();
    }
    public List<Shopping> findShoppingByDate(Date date){
        List<Shopping> listofShopByDate = new ArrayList<>();
        int i = 0;
        for (Shopping shop:getAllShoppings()){
            if(shop.getShopping_Date().equals(date)){
                listofShopByDate.add(i, shop);
                i++;
            }
        }
        return listofShopByDate;
    }
    public List<Shopping> findShoppingByCustomer(Customer customer){
        List<Shopping> listofShopByCustomer = new ArrayList<>();
        int i = 0;
        for (Shopping shop:getAllShoppings()){
            if(shop.getCustomer()!= null && shop.getCustomer().equals(customer)){
                listofShopByCustomer.add(i, shop);
                i++;
            }
        }
        return listofShopByCustomer;
    }
    public List<Shopping> findShoppingBySupplier(Supplier supplier){
        List<Shopping> listofShopBySupplier = new ArrayList<>();
        int i = 0;
        for (Shopping shop:getAllShoppings()){
            listofShopBySupplier.add(i, shop);
            i++;
        }
        return listofShopBySupplier;
    }
}
