package com.insumostecnologicos.api;


import com.insumostecnologicos.entity.OrderMain;
import com.insumostecnologicos.entity.ProductInOrder;
import com.insumostecnologicos.service.OrderService;
import com.insumostecnologicos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * The type Order controller.
 */
@RestController
@CrossOrigin
public class OrderController {
    /**
     * The Order service.
     */
    @Autowired
    OrderService orderService;
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * Order list page.
     *
     * @param page           the page
     * @param size           the size
     * @param authentication the authentication
     * @return the page
     */
    @GetMapping("/order")
    public Page<OrderMain> orderList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     Authentication authentication) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<OrderMain> orderPage;
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            orderPage = orderService.findByBuyerEmail(authentication.getName(), request);
        } else {
            orderPage = orderService.findAll(request);
        }
        return orderPage;
    }


    /**
     * Cancel response entity.
     *
     * @param orderId        the order id
     * @param authentication the authentication
     * @return the response entity
     */
    @PatchMapping("/order/cancel/{id}")
    public ResponseEntity<OrderMain> cancel(@PathVariable("id") Long orderId, Authentication authentication) {
        OrderMain orderMain = orderService.findOne(orderId);
        if (!authentication.getName().equals(orderMain.getBuyerEmail()) && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(orderService.cancel(orderId));
    }

    /**
     * Authorized response entity.
     *
     * @param orderId        the order id
     * @param authentication the authentication
     * @return the response entity
     */
    @PatchMapping("/order/authorized/{id}")
    public ResponseEntity<OrderMain> authorized(@PathVariable("id") Long orderId, Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(orderService.authorized(orderId));
    }

    /**
     * Received response entity.
     *
     * @param orderId        the order id
     * @param authentication the authentication
     * @return the response entity
     */
    @PatchMapping("/order/received/{id}")
    public ResponseEntity<OrderMain> received(@PathVariable("id") Long orderId, Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(orderService.received(orderId));
    }

    /**
     * Show response entity.
     *
     * @param orderId        the order id
     * @param authentication the authentication
     * @return the response entity
     */
    @GetMapping("/order/{id}")
    public ResponseEntity show(@PathVariable("id") Long orderId, Authentication authentication) {
        boolean isCustomer = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        OrderMain orderMain = orderService.findOne(orderId);
        if (isCustomer && !authentication.getName().equals(orderMain.getBuyerEmail())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Collection<ProductInOrder> items = orderMain.getProducts();
        return ResponseEntity.ok(orderMain);
    }
}
