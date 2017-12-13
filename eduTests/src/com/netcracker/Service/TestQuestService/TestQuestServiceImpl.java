package com.netcracker.Service.TestQuestService;

import com.netcracker.DAO.TestQuestDAO.TestQuestDAO;
import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import com.netcracker.Entities.TestQuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("testQuestService")
@Transactional
public class TestQuestServiceImpl implements TestQuestService {
    @Autowired
    private TestQuestDAO dao;

    public void add(TestQuest testQuest) {
        dao.create(testQuest);
    }

    public List<TestQuest> getAll() {
        return dao.getAll();
    }

    public void delete(TestQuest testQuest) {
        dao.delete(testQuest);
    }

    public void deleteById(TestQuestKey id) {
        dao.deleteById(id);
    }

    public TestQuest readById(TestQuestKey id) {
        return dao.readById(id);
    }

    public void update(TestQuest testQuest) {
        dao.update(testQuest);
    }
}
