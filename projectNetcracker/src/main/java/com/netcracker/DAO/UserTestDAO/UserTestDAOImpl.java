package com.netcracker.DAO.UserTestDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.UserTest;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserTestDAOImpl extends AbstractDAO implements UserTestDAO {
    public List<UserTest> getAll() {
        CriteriaQuery<UserTest> criteriaQuery = getSession().getCriteriaBuilder().createQuery(UserTest.class);
        criteriaQuery.from(UserTest.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public void create(UserTest userTest) {
        persist(userTest);
    }

    public void delete(UserTest userTest) {
        deleteEntity(userTest);
    }

    public void deleteById(Integer id) {
        delete(readById(id));
    }

    public UserTest readById(Integer id) {
        return (UserTest)getSession().get(UserTest.class, id);
    }

    public void update(UserTest userTest) {
        updateEntity(userTest);
    }
}
