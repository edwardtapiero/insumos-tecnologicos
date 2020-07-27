package com.insumostecnologicos.service;

import com.insumostecnologicos.entity.Cart;
import com.insumostecnologicos.entity.ProductInOrder;
import com.insumostecnologicos.entity.User;

import java.util.Collection;

/**
 * The interface Cart service.
 */
public interface CartService {
    /**
     * Gets cart.
     *
     * @param user the user
     * @return the cart
     */
    Cart getCart(User user);

    /**
     * Merge local cart.
     *
     * @param productInOrders the product in orders
     * @param user            the user
     */
    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    /**
     * Delete.
     *
     * @param itemId the item id
     * @param user   the user
     */
    void delete(String itemId, User user);

    /**
     * Checkout.
     *
     * @param user the user
     */
    void checkout(User user);
}
