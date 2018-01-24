package com.netcracker.DAO.TestQuestDAO;

import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import com.netcracker.Entities.TestQuest;

import java.util.List;

public interface TestQuestDAO {
    List<TestQuest> getAll();
    void create(TestQuest testQuest);
    void delete(TestQuest testQuest);
    void deleteById(TestQuestKey id);
    TestQuest readById(TestQuestKey id);
    void update(TestQuest testQuest);
}
