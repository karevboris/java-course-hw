package com.netcracker.DAO.UserDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.User;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDAOImpl extends AbstractDAO implements UserDAO {
    public List<User> getAll() {
        CriteriaQuery<User> criteriaQuery = getSession().getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public void create(User user) {
        persist(user);
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

    public void update(User user) {
        updateEntity(user);
    }
}
