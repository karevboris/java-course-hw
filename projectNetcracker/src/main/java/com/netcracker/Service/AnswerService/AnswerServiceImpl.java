package com.netcracker.Service.AnswerService;

import com.netcracker.DAO.AnswerDAO.AnswerDAO;
import com.netcracker.Entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.List;
import org.apache.log4j.Logger;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDAO dao;

    private static final Logger logger = Logger.getLogger(AnswerServiceImpl.class);

    public void setDao(AnswerDAO dao) {
        this.dao = dao;
    }

    public Answer add(Answer answer) {
        //logger.error("This is Error message, getAll()");
        return dao.create(answer);
    }

    public List<Answer> getAll() {
        return dao.getAll();
    }

    public void delete(Answer answer) {
        dao.delete(answer);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public Answer readById(Integer id) {
        //logger.error("This is Error message");
        return dao.readById(id);
    }

    public Answer update(Answer answer) {
        return dao.update(answer);
    }

    public List<Answer> getAnswers(Integer questId) {
        return dao.getAnswers(questId);
    }

    public void deleteAnswers(Integer questId) {
        dao.deleteAnswers(questId);
    }
}
