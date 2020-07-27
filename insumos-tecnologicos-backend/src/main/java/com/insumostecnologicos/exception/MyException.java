package com.insumostecnologicos.exception;


import com.insumostecnologicos.enums.ResultEnum;

/**
 * The type My exception.
 */
public class MyException extends RuntimeException {

    private Integer code;

    /**
     * Instantiates a new My exception.
     *
     * @param resultEnum the result enum
     */
    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    /**
     * Instantiates a new My exception.
     *
     * @param code    the code
     * @param message the message
     */
    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
