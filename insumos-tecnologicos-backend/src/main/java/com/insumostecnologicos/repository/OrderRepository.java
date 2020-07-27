package com.insumostecnologicos.repository;


import com.insumostecnologicos.entity.OrderMain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends JpaRepository<OrderMain, Integer> {
    /**
     * Find by order id order main.
     *
     * @param orderId the order id
     * @return the order main
     */
    OrderMain findByOrderId(Long orderId);


    /**
     * Find all by order status order by create time desc page.
     *
     * @param orderStatus the order status
     * @param pageable    the pageable
     * @return the page
     */
    Page<OrderMain> findAllByOrderStatusOrderByCreateTimeDesc(Integer orderStatus, Pageable pageable);


    /**
     * Find all by buyer email order by order status asc create time desc page.
     *
     * @param buyerEmail the buyer email
     * @param pageable   the pageable
     * @return the page
     */
    Page<OrderMain> findAllByBuyerEmailOrderByOrderStatusAscCreateTimeDesc(String buyerEmail, Pageable pageable);

    /**
     * Find all by order by order status asc create time desc page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<OrderMain> findAllByOrderByOrderStatusAscCreateTimeDesc(Pageable pageable);

    /**
     * Find all by buyer phone order by order status asc create time desc page.
     *
     * @param buyerPhone the buyer phone
     * @param pageable   the pageable
     * @return the page
     */
    Page<OrderMain> findAllByBuyerPhoneOrderByOrderStatusAscCreateTimeDesc(String buyerPhone, Pageable pageable);
}
