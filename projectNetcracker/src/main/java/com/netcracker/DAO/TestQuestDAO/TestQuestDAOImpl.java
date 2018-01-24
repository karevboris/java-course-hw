package com.netcracker.DAO.TestQuestDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import com.netcracker.Entities.TestQuest;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TestQuestDAOImpl extends AbstractDAO implements TestQuestDAO {
    public List<TestQuest> getAll() {
        CriteriaQuery<TestQuest> criteriaQuery = getSession().getCriteriaBuilder().createQuery(TestQuest.class);
        criteriaQuery.from( TestQuest.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public void create( TestQuest testQuest) {
        persist(testQuest);
    }

    public void delete( TestQuest testQuest) {
        deleteEntity(testQuest);
    }

    public void deleteById(TestQuestKey id) {
        delete(readById(id));
    }

    public TestQuest readById(TestQuestKey id) {
        return (TestQuest)getSession().get( TestQuest.class, id);
    }

    public void update( TestQuest testQuest) {
        updateEntity(testQuest);
    }
}
