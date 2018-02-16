package com.netcracker.DAO.QuestionDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.Question;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class QuestionDAOImpl extends AbstractDAO<Question> implements QuestionDAO {
    public List<Question> getAll() {
        CriteriaQuery<Question> criteriaQuery = getSession().getCriteriaBuilder().createQuery(Question.class);
        criteriaQuery.from(Question.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public Question create(Question question) {
        persist(question);
        return question;
    }

    public void delete(Question answer) {
        deleteEntity(answer);
    }

    public void deleteById(Integer id) {
        delete(readById(id));
    }

    public Question readById(Integer id) {
        return (Question)getSession().get(Question.class, id);
    }

    public Question update(Question question) {
        updateEntity(question);
        return question;
    }
}
