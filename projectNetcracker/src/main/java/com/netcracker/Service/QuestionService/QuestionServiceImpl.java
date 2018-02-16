package com.netcracker.Service.QuestionService;

import com.netcracker.DAO.QuestionDAO.QuestionDAO;
import com.netcracker.Entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDAO dao;

    public void setDao(QuestionDAO dao) {
        this.dao = dao;
    }

    public Question add(Question question) {
        return dao.create(question);
    }

    public List<Question> getAll() {
        return dao.getAll();
    }

    public void delete(Question question) {
        dao.delete(question);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public Question readById(Integer id) {
        return dao.readById(id);
    }

    public Question update(Question question) {
        return dao.update(question);
    }
}
