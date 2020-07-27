package com.insumostecnologicos.service.impl;


import com.insumostecnologicos.entity.Cart;
import com.insumostecnologicos.entity.OrderMain;
import com.insumostecnologicos.entity.ProductInOrder;
import com.insumostecnologicos.entity.User;
import com.insumostecnologicos.repository.CartRepository;
import com.insumostecnologicos.repository.OrderRepository;
import com.insumostecnologicos.repository.ProductInOrderRepository;
import com.insumostecnologicos.repository.UserRepository;
import com.insumostecnologicos.service.CartService;
import com.insumostecnologicos.service.ProductService;
import com.insumostecnologicos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * The type Cart service.
 */
@Service
public class CartServiceImpl implements CartService {
    /**
     * The Product service.
     */
    @Autowired
    ProductService productService;
    /**
     * The Order repository.
     */
    @Autowired
    OrderRepository orderRepository;
    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * The Product in order repository.
     */
    @Autowired
    ProductInOrderRepository productInOrderRepository;
    /**
     * The Cart repository.
     */
    @Autowired
    CartRepository cartRepository;
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    @Override
    public Cart getCart(User user) {
        return user.getCart();
    }

    @Override
    @Transactional
    public void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user) {
        Cart finalCart = user.getCart();
        productInOrders.forEach(productInOrder -> {
            Set<ProductInOrder> set = finalCart.getProducts();
            Optional<ProductInOrder> old = set.stream().filter(e -> e.getProductId().equals(productInOrder.getProductId())).findFirst();
            ProductInOrder prod;
            if (old.isPresent()) {
                prod = old.get();
                prod.setCount(productInOrder.getCount() + prod.getCount());
            } else {
                prod = productInOrder;
                prod.setCart(finalCart);
                finalCart.getProducts().add(prod);
            }
            productInOrderRepository.save(prod);
        });
        cartRepository.save(finalCart);

    }

    @Override
    @Transactional
    public void delete(String itemId, User user) {
        Optional<ProductInOrder> op = user.getCart().getProducts().stream().filter(e -> itemId.equals(e.getProductId())).findFirst();
        op.ifPresent(productInOrder -> {
            productInOrder.setCart(null);
            productInOrderRepository.deleteById(productInOrder.getId());
        });
    }


    @Override
    @Transactional
    public void checkout(User user) {
        OrderMain order = new OrderMain(user);
        orderRepository.save(order);

        user.getCart().getProducts().forEach(productInOrder -> {
            productInOrder.setCart(null);
            productInOrder.setOrderMain(order);
            productService.decreaseStock(productInOrder.getProductId(), productInOrder.getCount());
            productInOrderRepository.save(productInOrder);
        });

    }
}
