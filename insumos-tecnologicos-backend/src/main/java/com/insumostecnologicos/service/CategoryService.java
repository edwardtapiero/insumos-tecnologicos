package com.insumostecnologicos.service;

import com.insumostecnologicos.entity.ProductCategory;

import java.util.List;

/**
 * The interface Category service.
 */
public interface CategoryService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<ProductCategory> findAll();

    /**
     * Find by category type product category.
     *
     * @param categoryType the category type
     * @return the product category
     */
    ProductCategory findByCategoryType(Integer categoryType);

    /**
     * Find by category type in list.
     *
     * @param categoryTypeList the category type list
     * @return the list
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * Save product category.
     *
     * @param productCategory the product category
     * @return the product category
     */
    ProductCategory save(ProductCategory productCategory);


}
