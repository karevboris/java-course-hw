package com.netcracker.DAO.QuestAnswerDAO;

import com.netcracker.Entities.PrimaryKey.QuestAnswerKey;
import com.netcracker.Entities.QuestAnswer;

import java.util.List;

public interface QuestAnswerDAO {
    List<QuestAnswer> getAll();
    void create(QuestAnswer questAnswer);
    void delete(QuestAnswer questAnswer);
    void deleteById(QuestAnswerKey id);
    QuestAnswer readById(QuestAnswerKey id);
    void update(QuestAnswer questAnswer);
}
