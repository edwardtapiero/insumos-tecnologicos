package com.insumostecnologicos.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * The type Login form.
 */
@Data
public class LoginForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
