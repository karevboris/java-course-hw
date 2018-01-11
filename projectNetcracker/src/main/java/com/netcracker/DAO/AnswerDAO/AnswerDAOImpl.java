package com.netcracker.DAO.AnswerDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.Answer;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AnswerDAOImpl extends AbstractDAO implements AnswerDAO {

    public List<Answer> getAll() {
        CriteriaQuery<Answer> criteriaQuery = getSession().getCriteriaBuilder().createQuery(Answer.class);
        criteriaQuery.from(Answer.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public void create(Answer answer) {
        persist(answer);
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

    public void update(Answer answer) {
        updateEntity(answer);
    }
}
