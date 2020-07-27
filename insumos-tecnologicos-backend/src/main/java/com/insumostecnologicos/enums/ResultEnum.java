package com.insumostecnologicos.enums;

import lombok.Getter;

/**
 * The enum Result enum.
 */
@Getter
public enum ResultEnum {

    /**
     * The Param error.
     */
    PARAM_ERROR(1, "Parameter Error!"),
    /**
     * The Product not exist.
     */
    PRODUCT_NOT_EXIST(10, "Product does not exit!"),
    /**
     * The Product not enough.
     */
    PRODUCT_NOT_ENOUGH(11, "Not enough products in stock!"),
    /**
     * The Product status error.
     */
    PRODUCT_STATUS_ERROR(12, "Status is incorrect!"),
    /**
     * The Product off sale.
     */
    PRODUCT_OFF_SALE(13, "Product is off sale!"),
    /**
     * The Product not in cart.
     */
    PRODUCT_NOT_IN_CART(14, "Product is not in the cart!"),
    /**
     * The Cart checkout success.
     */
    CART_CHECKOUT_SUCCESS(20, "Checkout successfully! "),

    /**
     * The Category not found.
     */
    CATEGORY_NOT_FOUND(30, "Category does not exit!"),

    /**
     * The Order not found.
     */
    ORDER_NOT_FOUND(60, "OrderMain is not exit!"),
    /**
     * The Order status error.
     */
    ORDER_STATUS_ERROR(61, "Status is not correct"),


    /**
     * The Valid error.
     */
    VALID_ERROR(50, "Wrong information"),
    /**
     * The User not fount.
     */
    USER_NOT_FOUNT(40, "User is not found!");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
