package com.insumostecnologicos.repository;


import com.insumostecnologicos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, String> {
    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    User findByEmail(String email);

    /**
     * Find all by role collection.
     *
     * @param role the role
     * @return the collection
     */
    Collection<User> findAllByRole(String role);

}
