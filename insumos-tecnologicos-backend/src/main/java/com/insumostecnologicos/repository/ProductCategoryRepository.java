package com.insumostecnologicos.repository;

import com.insumostecnologicos.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Product category repository.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * Find by category type in order by category type asc list.
     *
     * @param categoryTypes the category types
     * @return the list
     */
    List<ProductCategory> findByCategoryTypeInOrderByCategoryTypeAsc(List<Integer> categoryTypes);

    /**
     * Find all by order by category type list.
     *
     * @return the list
     */
    List<ProductCategory> findAllByOrderByCategoryType();

    /**
     * Find by category type product category.
     *
     * @param categoryType the category type
     * @return the product category
     */
    ProductCategory findByCategoryType(Integer categoryType);
}
