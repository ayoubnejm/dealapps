package com.example.dealapps.service;

import com.example.dealapps.dto.CategoryDto;
import com.example.dealapps.exception.MyResourceNotFoundException;
import com.example.dealapps.model.Category;

import java.util.List;

/**
 * @author NEJMEDDINE Ayoub
 * @created 04/08/2020 -10:09
 */
public interface CategoryService {

    /**
     * get categorys list
     * @return
     */
    List<Category> findAll();

    /**
     * get category by id
     * @param id id
     * @return category founded
     * @throws MyResourceNotFoundException NotFoundException
     */
    Category findById(Long id);

    /**
     * Create or update a Category
     * @param categoryDto category
     * @return Category created
     */
    Category saveOrUpdate(CategoryDto categoryDto);

    /**
     * get By Id
     * @param id id of category
     * @return category founded
     */
    Category getById(Long id);

    /**
     * delete a category by id
     * @param id of category
     */
    void deleteById(Long id);

}
