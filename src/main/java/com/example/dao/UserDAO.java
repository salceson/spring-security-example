package com.example.dao;

import com.example.model.User;

import java.util.Optional;

/**
 * @author Michał Ciołczyk
 */
public interface UserDAO {
    boolean save(User user);

    Optional<User> findByPK(long pk);

    Optional<User> findByUsername(String username);
}
