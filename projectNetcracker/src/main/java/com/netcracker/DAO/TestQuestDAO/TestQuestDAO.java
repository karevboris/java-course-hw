package com.netcracker.DAO.TestQuestDAO;

import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import com.netcracker.Entities.Question;
import com.netcracker.Entities.TestQuest;

import java.util.List;

public interface TestQuestDAO {
    List<TestQuest> getAll();
    TestQuest create(TestQuest testQuest);
    void delete(TestQuest testQuest);
    void deleteById(TestQuestKey id);
    TestQuest readById(TestQuestKey id);
    TestQuest update(TestQuest testQuest);
    List<Question> getQuestions(Integer testId);
    void deleteQuestions(Integer testId);
    Integer getTestTime(Integer testId);
}
