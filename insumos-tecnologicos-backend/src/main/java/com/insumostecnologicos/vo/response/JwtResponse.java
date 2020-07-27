package com.insumostecnologicos.vo.response;

import lombok.Data;

/**
 * The type Jwt response.
 */
@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String account;
    private String name;
    private String role;

    /**
     * Instantiates a new Jwt response.
     *
     * @param token   the token
     * @param account the account
     * @param name    the name
     * @param role    the role
     */
    public JwtResponse(String token, String account, String name, String role) {
        this.account = account;
        this.name = name;
        this.token = token;
        this.role = role;
    }
}
