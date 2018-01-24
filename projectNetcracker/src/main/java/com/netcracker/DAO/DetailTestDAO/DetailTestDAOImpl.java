package com.netcracker.DAO.DetailTestDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.DetailTest;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DetailTestDAOImpl extends AbstractDAO implements DetailTestDAO {
    public List<DetailTest> getAll() {
        CriteriaQuery<DetailTest> criteriaQuery = getSession().getCriteriaBuilder().createQuery(DetailTest.class);
        criteriaQuery.from(DetailTest.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public void create(DetailTest detailTest) {
        persist(detailTest);
    }

    public void delete(DetailTest detailTest) {
        deleteEntity(detailTest);
    }

    public void deleteById(Integer id) {
        delete(readById(id));
    }

    public DetailTest readById(Integer id) {
        return (DetailTest)getSession().get(DetailTest.class, id);
    }

    public void update(DetailTest detailTest) {
        updateEntity(detailTest);
    }
}
