package com.netcracker.DAO.TestQuestDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import com.netcracker.Entities.Question;
import com.netcracker.Entities.TestQuest;
import org.hibernate.Query;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TestQuestDAOImpl extends AbstractDAO<TestQuest> implements TestQuestDAO {
    public List<TestQuest> getAll() {
        CriteriaQuery<TestQuest> criteriaQuery = getSession().getCriteriaBuilder().createQuery(TestQuest.class);
        criteriaQuery.from( TestQuest.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public TestQuest create( TestQuest testQuest) {
        persist(testQuest);
        int i=0;
        i++;
        return testQuest;
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

    public TestQuest update(TestQuest testQuest) {
        updateEntity(testQuest);
        return testQuest;
    }

    public List<Question> getQuestions(Integer testId) {
        String query = "select * from questions where questions.quest_id in (select quest_id from test_quest where test_quest.test_id=:testId)";
        return getSession().createSQLQuery(query).addEntity(Question.class).setParameter("testId", testId).getResultList();
    }

    public void deleteQuestions(Integer testId) {
        for(Question question:getQuestions(testId)){
            TestQuestKey testQuestKey = new TestQuestKey();
            testQuestKey.setQuestId(question.getId());
            testQuestKey.setTestId(testId);
            deleteById(testQuestKey);
        }
    }

    public Integer getTestTime(Integer testId) {
        String query = "select sum(questions.time) as value from questions where questions.quest_id in (select test_quest.quest_id from test_quest where test_quest.test_id=:testId)";
        int res = (Integer)getSession().createSQLQuery(query).addScalar("value", StandardBasicTypes.INTEGER).setParameter("testId", testId).uniqueResult();
        int i=0;
        if(res>0) i++;
        return res;
    }
}
