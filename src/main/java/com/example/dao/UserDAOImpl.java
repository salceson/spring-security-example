package com.example.dao;

import com.example.model.User;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Michał Ciołczyk
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public boolean save(User user) {
        return super.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Optional<User> findByPK(long pk) {
        return Optional.ofNullable(super.find(pk));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Optional<User> findByUsername(String username) {
        Search search = new Search(User.class);
        search.addFilter(Filter.equal("username", username));
        final User user = searchUnique(search);
        return Optional.ofNullable(user);
    }
}
