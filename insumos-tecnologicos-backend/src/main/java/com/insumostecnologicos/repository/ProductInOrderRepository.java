package com.insumostecnologicos.repository;

import com.insumostecnologicos.entity.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Product in order repository.
 */
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
