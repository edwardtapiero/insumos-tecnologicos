package com.insumostecnologicos.api;


import com.insumostecnologicos.entity.Cart;
import com.insumostecnologicos.entity.ProductInOrder;
import com.insumostecnologicos.entity.ProductInfo;
import com.insumostecnologicos.entity.User;
import com.insumostecnologicos.form.ItemForm;
import com.insumostecnologicos.repository.ProductInOrderRepository;
import com.insumostecnologicos.service.CartService;
import com.insumostecnologicos.service.ProductInOrderService;
import com.insumostecnologicos.service.ProductService;
import com.insumostecnologicos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

/**
 * The type Cart controller.
 */
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
    /**
     * The Cart service.
     */
    @Autowired
    CartService cartService;
    /**
     * The User service.
     */
    @Autowired
    UserService userService;
    /**
     * The Product service.
     */
    @Autowired
    ProductService productService;
    /**
     * The Product in order service.
     */
    @Autowired
    ProductInOrderService productInOrderService;
    /**
     * The Product in order repository.
     */
    @Autowired
    ProductInOrderRepository productInOrderRepository;

    /**
     * Merge cart response entity.
     *
     * @param productInOrders the product in orders
     * @param principal       the principal
     * @return the response entity
     */
    @PostMapping("")
    public ResponseEntity<Cart> mergeCart(@RequestBody Collection<ProductInOrder> productInOrders, Principal principal) {
        User user = userService.findOne(principal.getName());
        try {
            cartService.mergeLocalCart(productInOrders, user);
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Merge Cart Failed");
        }
        return ResponseEntity.ok(cartService.getCart(user));
    }

    /**
     * Gets cart.
     *
     * @param principal the principal
     * @return the cart
     */
    @GetMapping("")
    public Cart getCart(Principal principal) {
        User user = userService.findOne(principal.getName());
        return cartService.getCart(user);
    }


    /**
     * Add to cart boolean.
     *
     * @param form      the form
     * @param principal the principal
     * @return the boolean
     */
    @PostMapping("/add")
    public boolean addToCart(@RequestBody ItemForm form, Principal principal) {
        ProductInfo productInfo = productService.findOne(form.getProductId());
        try {
            mergeCart(Collections.singleton(new ProductInOrder(productInfo, form.getQuantity())), principal);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Modify item product in order.
     *
     * @param itemId    the item id
     * @param quantity  the quantity
     * @param principal the principal
     * @return the product in order
     */
    @PutMapping("/{itemId}")
    public ProductInOrder modifyItem(@PathVariable("itemId") String itemId, @RequestBody Integer quantity, Principal principal) {
        User user = userService.findOne(principal.getName());
        productInOrderService.update(itemId, quantity, user);
        return productInOrderService.findOne(itemId, user);
    }

    /**
     * Delete item.
     *
     * @param itemId    the item id
     * @param principal the principal
     */
    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable("itemId") String itemId, Principal principal) {
        User user = userService.findOne(principal.getName());
        cartService.delete(itemId, user);
        // flush memory into DB
    }


    /**
     * Checkout response entity.
     *
     * @param principal the principal
     * @return the response entity
     */
    @PostMapping("/checkout")
    public ResponseEntity checkout(Principal principal) {
        User user = userService.findOne(principal.getName());// Email as username
        cartService.checkout(user);
        return ResponseEntity.ok(null);
    }
}
