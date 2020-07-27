package com.insumostecnologicos.service;


import com.insumostecnologicos.entity.OrderMain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The interface Order service.
 */
public interface OrderService {
    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<OrderMain> findAll(Pageable pageable);

    /**
     * Find by status page.
     *
     * @param status   the status
     * @param pageable the pageable
     * @return the page
     */
    Page<OrderMain> findByStatus(Integer status, Pageable pageable);

    /**
     * Find by buyer email page.
     *
     * @param email    the email
     * @param pageable the pageable
     * @return the page
     */
    Page<OrderMain> findByBuyerEmail(String email, Pageable pageable);

    /**
     * Find by buyer phone page.
     *
     * @param phone    the phone
     * @param pageable the pageable
     * @return the page
     */
    Page<OrderMain> findByBuyerPhone(String phone, Pageable pageable);

    /**
     * Find one order main.
     *
     * @param orderId the order id
     * @return the order main
     */
    OrderMain findOne(Long orderId);

    /**
     * Authorized order main.
     *
     * @param orderId the order id
     * @return the order main
     */
    OrderMain authorized(Long orderId);

    /**
     * Received order main.
     *
     * @param orderId the order id
     * @return the order main
     */
    OrderMain received(Long orderId);

    /**
     * Cancel order main.
     *
     * @param orderId the order id
     * @return the order main
     */
    OrderMain cancel(Long orderId);

}
