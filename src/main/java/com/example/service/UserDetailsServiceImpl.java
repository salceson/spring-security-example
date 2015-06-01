package com.example.service;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Michał Ciołczyk
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final String MESSAGE_FORMAT = "Cannot find username %s.";
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> userOptional = userDAO.findByUsername(username);
        return userOptional.orElseThrow(() -> new UsernameNotFoundException(String.format(MESSAGE_FORMAT, username)));
    }
}
