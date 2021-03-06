package com.netcracker.Service.TestQuestService;

import com.netcracker.DAO.TestQuestDAO.TestQuestDAO;
import com.netcracker.Entities.PrimaryKey.TestQuestKey;
import com.netcracker.Entities.Question;
import com.netcracker.Entities.TestQuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestQuestServiceImpl implements TestQuestService {
    @Autowired
    private TestQuestDAO dao;

    public void setDao(TestQuestDAO dao) {
        this.dao = dao;
    }

    public TestQuest add(TestQuest testQuest) {
        return dao.create(testQuest);
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

    public TestQuest update(TestQuest testQuest) {
        return dao.update(testQuest);
    }

    public List<Question> getQuestions(Integer testId) {
        return dao.getQuestions(testId);
    }

    public void deleteQuestions(Integer testId) {
        dao.deleteQuestions(testId);
    }

    public Integer getTestTime(Integer testId) {
        return dao.getTestTime(testId);
    }
}
