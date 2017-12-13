package com.netcracker.Service.AnswerService;

import com.netcracker.DAO.AnswerDAO.AnswerDAO;
import com.netcracker.Entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("answerService")
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDAO dao;

    public void add(Answer answer) {
        dao.create(answer);
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
        return dao.readById(id);
    }

    public void update(Answer answer) {
        dao.update(answer);
    }
}
