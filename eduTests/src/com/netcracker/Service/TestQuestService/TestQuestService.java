package com.netcracker.Service.TestQuestService;

import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import com.netcracker.Entities.TestQuest;

import java.util.List;

public interface TestQuestService {
    List<TestQuest> getAll();
    void add(TestQuest testQuest);
    void delete(TestQuest testQuest);
    void deleteById(TestQuestKey id);
    TestQuest readById(TestQuestKey id);
    void update(TestQuest testQuest);
}
