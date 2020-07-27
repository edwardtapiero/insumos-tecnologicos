package com.insumostecnologicos.service;

import com.insumostecnologicos.entity.ProductInOrder;
import com.insumostecnologicos.entity.User;

/**
 * The interface Product in order service.
 */
public interface ProductInOrderService {
    /**
     * Update.
     *
     * @param itemId   the item id
     * @param quantity the quantity
     * @param user     the user
     */
    void update(String itemId, Integer quantity, User user);

    /**
     * Find one product in order.
     *
     * @param itemId the item id
     * @param user   the user
     * @return the product in order
     */
    ProductInOrder findOne(String itemId, User user);
}
