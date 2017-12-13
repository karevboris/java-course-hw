package com.netcracker.Service.QuestAnswerService;

import com.netcracker.Entities.PrimaryKey.QuestAnswerKey;
import com.netcracker.Entities.QuestAnswer;

import java.util.List;

public interface QuestAnswerService {
    List<QuestAnswer> getAll();
    void add(QuestAnswer questAnswer);
    void delete(QuestAnswer questAnswer);
    void deleteById(QuestAnswerKey id);
    QuestAnswer readById(QuestAnswerKey id);
    void update(QuestAnswer questAnswer);
}
