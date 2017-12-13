package com.netcracker.Service.QuestAnswerService;

import com.netcracker.DAO.QuestAnswerDAO.QuestAnswerDAO;
import com.netcracker.Entities.PrimaryKey.QuestAnswerKey;
import com.netcracker.Entities.QuestAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questAnswerService")
@Transactional
public class QuestAnswerServiceImpl implements QuestAnswerService {
    @Autowired
    private QuestAnswerDAO dao;

    public void add(QuestAnswer questAnswer) {
        dao.create(questAnswer);
    }

    public List<QuestAnswer> getAll() {
        return dao.getAll();
    }

    public void delete(QuestAnswer questAnswer) {
        dao.delete(questAnswer);
    }

    public void deleteById(QuestAnswerKey id) {
        dao.deleteById(id);
    }

    public QuestAnswer readById(QuestAnswerKey id) {
        return dao.readById(id);
    }

    public void update(QuestAnswer questAnswer) {
        dao.update(questAnswer);
    }
}
