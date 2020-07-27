package com.insumostecnologicos.repository;

import com.insumostecnologicos.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Cart repository.
 */
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
