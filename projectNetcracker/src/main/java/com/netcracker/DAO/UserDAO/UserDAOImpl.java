package com.netcracker.DAO.UserDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.User;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {
    public List<User> getAll() {
        CriteriaQuery<User> criteriaQuery = getSession().getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public User readByUsername(String username) {
        String query = "select * from users where users.login=:username";
        return (User)getSession().createSQLQuery(query).addEntity(User.class).setParameter("username", username).getResultList().get(0);
    }

    public User create(User user) {
        persist(user);
        return user;
    }

    public void delete(User user) {
        deleteEntity(user);
    }

    public void deleteById(Integer id) {
        delete(readById(id));
    }

    public User readById(Integer id) {
        return (User)getSession().get(User.class, id);
    }

    public User update(User user) {
        updateEntity(user);
        return user;
    }
}
