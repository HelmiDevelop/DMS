/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.services;

import com.helmidev.entities.Customer;
import com.helmidev.jpacontrollers.CustomerJpaController;
import com.helmidev.jpacontrollers.exceptions.IllegalOrphanException;
import com.helmidev.jpacontrollers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author hoben
 */
public class CustomerService {

    private final CustomerJpaController customerJpa;

    public CustomerService() {

        customerJpa = new CustomerJpaController();
    }

    public void addCustomer(Customer customer) throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        try {
            String validationMsg = "";
            Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
            if(!violations.isEmpty()){
                for (ConstraintViolation<Customer> violation : violations) {
                    System.out.println(violation.getMessage());
                    validationMsg += "->"+violation.getMessage() + "\n";
                }
                throw new ValidationException(validationMsg);
                
            }else{
                customerJpa.create(customer);
            }            
            
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void updateCustomer(Customer customer) throws NonexistentEntityException, Exception {
        customerJpa.update(customer);
    }

    public void removeCustomer(Customer customer) throws IllegalOrphanException, NonexistentEntityException {
        customerJpa.destroy(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerJpa.findAllCustomers();
    }

    public List<Customer> findCustomerByFName(String FName) {
        List<Customer> listOfCustomerByFName = new ArrayList<>();
        int i = 0;
        for (Customer customer : getAllCustomer()) {
            if (customer.getFirst_name().equals(FName)) {
                listOfCustomerByFName.add(i, customer);
                i++;
            }
        }

        return listOfCustomerByFName;
    }

    public List<Customer> findCustomerByLName(String LName) {
        List<Customer> listOfCustomerByLName = new ArrayList<>();
        int i = 0;
        for (Customer customer : getAllCustomer()) {
            if (customer.getLast_name().equals(LName)) {
                listOfCustomerByLName.add(i, customer);
                i++;
            }
        }

        return listOfCustomerByLName;
    }

    public Customer findCustomerByEmail(String email) {

        for (Customer customer : getAllCustomer()) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        System.out.println("Customer with the email " + email + " is not found");
        return null;
    }

    public List<Customer> findDeptfullCustomer() {

        List<Customer> listofDebtfullCustomer = new ArrayList<>();
        int i = 0;
        for (Customer customer : getAllCustomer()) {
            if (customer.getAccount() <= -50) {
                listofDebtfullCustomer.add(i, customer);
                i++;
            }
        }
        return listofDebtfullCustomer;
    }

}
