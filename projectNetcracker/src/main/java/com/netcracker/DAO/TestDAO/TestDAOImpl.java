package com.netcracker.DAO.TestDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.Test;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TestDAOImpl extends AbstractDAO implements TestDAO {

    public List<Test> getAll() {
        CriteriaQuery<Test> criteriaQuery = getSession().getCriteriaBuilder().createQuery(Test.class);
        criteriaQuery.from(Test.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public void create(Test test) {
        persist(test);
    }

    public void delete(Test test) {
        deleteEntity(test);
    }

    public void deleteById(Integer id) {
        delete(readById(id));
    }

    public Test readById(Integer id) {
        return (Test)getSession().get(Test.class, id);
    }

    public void update(Test test) {
        updateEntity(test);
    }
}
