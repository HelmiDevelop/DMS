/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmidev.services;

import com.helmidev.jpacontrollers.CategoryJpaController;
import com.helmidev.entities.Category;
import com.helmidev.jpacontrollers.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Helmi Omrane
 */
public class CategoryService {

    private final CategoryJpaController categoryJpa;

    public CategoryService() {

        categoryJpa = new CategoryJpaController();
    }

    public void addCategory(Category category) throws Exception {
        categoryJpa.create(category);
    }

    public void updateCategory(Category category) throws Exception {
        categoryJpa.update(category);
    }

    public void removeCategory(Category category) throws NonexistentEntityException {
        categoryJpa.destroy(category);
    }

    public List<Category> getAllCategories() {
        return categoryJpa.findCategoryEntities();
    }

    public Category findCategoryByName(String name) {

        return categoryJpa.findCategoryEntities().stream()
                .filter(predicate -> predicate.getCategory_Name().equals(name))
                .findFirst().get();
    }

}
