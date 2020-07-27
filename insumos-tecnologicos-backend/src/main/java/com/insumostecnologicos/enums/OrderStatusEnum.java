package com.insumostecnologicos.enums;

/**
 * The enum Order status enum.
 */
public enum OrderStatusEnum implements CodeEnum {
    /**
     * New order status enum.
     */
    NEW(0, "Nuevo"),
    /**
     * Authorized order status enum.
     */
    AUTHORIZED(1, "Autorizado"),
    /**
     * Rejected order status enum.
     */
    REJECTED(2, "Rechazado"),
    /**
     * Received order status enum.
     */
    RECEIVED(3, "Recibido");

    private int code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
