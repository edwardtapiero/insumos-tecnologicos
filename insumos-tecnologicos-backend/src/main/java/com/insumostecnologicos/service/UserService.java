package com.insumostecnologicos.service;


import com.insumostecnologicos.entity.User;

import java.util.Collection;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Find one user.
     *
     * @param email the email
     * @return the user
     */
    User findOne(String email);

    /**
     * Find by role collection.
     *
     * @param role the role
     * @return the collection
     */
    Collection<User> findByRole(String role);

    /**
     * Save user.
     *
     * @param user the user
     * @return the user
     */
    User save(User user);

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    User update(User user);
}
