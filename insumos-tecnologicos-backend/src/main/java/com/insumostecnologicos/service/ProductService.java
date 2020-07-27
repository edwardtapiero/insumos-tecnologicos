package com.insumostecnologicos.service;


import com.insumostecnologicos.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The interface Product service.
 */
public interface ProductService {

    /**
     * Find one product info.
     *
     * @param productId the product id
     * @return the product info
     */
    ProductInfo findOne(String productId);

    /**
     * Find up all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<ProductInfo> findUpAll(Pageable pageable);

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * Find all in category page.
     *
     * @param categoryType the category type
     * @param pageable     the pageable
     * @return the page
     */
    Page<ProductInfo> findAllInCategory(Integer categoryType, Pageable pageable);

    /**
     * Increase stock.
     *
     * @param productId the product id
     * @param amount    the amount
     */
    void increaseStock(String productId, int amount);

    /**
     * Decrease stock.
     *
     * @param productId the product id
     * @param amount    the amount
     */
    void decreaseStock(String productId, int amount);

    ProductInfo offSale(String productId);

    /**
     * On sale product info.
     *
     * @param productId the product id
     * @return the product info
     */
    ProductInfo onSale(String productId);

    /**
     * Update product info.
     *
     * @param productInfo the product info
     * @return the product info
     */
    ProductInfo update(ProductInfo productInfo);

    /**
     * Save product info.
     *
     * @param productInfo the product info
     * @return the product info
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * Delete.
     *
     * @param productId the product id
     */
    void delete(String productId);


}
