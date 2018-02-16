package com.netcracker.DAO.AnswerDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.Answer;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AnswerDAOImpl extends AbstractDAO<Answer> implements AnswerDAO {

    public List<Answer> getAll() {
        CriteriaQuery<Answer> criteriaQuery = getSession().getCriteriaBuilder().createQuery(Answer.class);
        criteriaQuery.from(Answer.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public Answer create(Answer answer) {
        persist(answer);
        return answer;
    }

    public void delete(Answer answer) {
        deleteEntity(answer);
    }

    public void deleteById(Integer id) {
        delete(readById(id));
    }

    public Answer readById(Integer id) {
       return (Answer)getSession().get(Answer.class, id);
    }

    public Answer update(Answer answer) {
        updateEntity(answer);
        return answer;
    }

    public List<Answer> getAnswers(Integer questId) {
        String query = "select * from answers where answers.quest_id =:questId";
        return getSession().createSQLQuery(query).addEntity(Answer.class).setParameter("questId", questId).getResultList();
    }

    public void deleteAnswers(Integer questId) {
        for (Answer answer:getAnswers(questId)){
            delete(answer);
        }
    }
}
