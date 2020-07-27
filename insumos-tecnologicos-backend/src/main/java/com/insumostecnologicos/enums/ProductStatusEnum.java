package com.insumostecnologicos.enums;

import lombok.Getter;

/**
 * The enum Product status enum.
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    /**
     * Up product status enum.
     */
    UP(0, "Available"),
    /**
     * Down product status enum.
     */
    DOWN(1, "Unavailable");
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Gets status.
     *
     * @param code the code
     * @return the status
     */
    public String getStatus(Integer code) {

        for (ProductStatusEnum statusEnum : ProductStatusEnum.values()) {
            if (statusEnum.getCode() == code) return statusEnum.getMessage();
        }
        return "";
    }

    public Integer getCode() {
        return code;
    }
}
