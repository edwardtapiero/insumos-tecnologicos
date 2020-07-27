package com.insumostecnologicos.repository;

import com.insumostecnologicos.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Product info repository.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**
     * Find by product id product info.
     *
     * @param id the id
     * @return the product info
     */
    ProductInfo findByProductId(String id);

    /**
     * Find all by product status order by product id asc page.
     *
     * @param productStatus the product status
     * @param pageable      the pageable
     * @return the page
     */
    Page<ProductInfo> findAllByProductStatusOrderByProductIdAsc(Integer productStatus, Pageable pageable);

    /**
     * Find all by category type order by product id asc page.
     *
     * @param categoryType the category type
     * @param pageable     the pageable
     * @return the page
     */
    Page<ProductInfo> findAllByCategoryTypeOrderByProductIdAsc(Integer categoryType, Pageable pageable);

    /**
     * Find all by order by product id page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<ProductInfo> findAllByOrderByProductId(Pageable pageable);

}
