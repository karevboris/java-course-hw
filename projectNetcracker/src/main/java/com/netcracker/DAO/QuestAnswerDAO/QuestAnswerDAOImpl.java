package com.netcracker.DAO.QuestAnswerDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.PrimaryKey.QuestAnswerKey;
import com.netcracker.Entities.QuestAnswer;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class QuestAnswerDAOImpl extends AbstractDAO implements QuestAnswerDAO {
    public List<QuestAnswer> getAll() {
        CriteriaQuery<QuestAnswer> criteriaQuery = getSession().getCriteriaBuilder().createQuery(QuestAnswer.class);
        criteriaQuery.from(QuestAnswer.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public void create(QuestAnswer questAnswer) {
        persist(questAnswer);
    }

    public void delete(QuestAnswer questAnswer) {
        deleteEntity(questAnswer);
    }

    public void deleteById(QuestAnswerKey id) {
        delete(readById(id));
    }

    public QuestAnswer readById(QuestAnswerKey id) {
        return (QuestAnswer)getSession().get(QuestAnswer.class, id);
    }

    public void update(QuestAnswer questAnswer) {
        updateEntity(questAnswer);
    }
}
