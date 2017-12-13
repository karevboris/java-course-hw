package com.netcracker.DAO.QuestionDAO;

import com.netcracker.Entities.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> getAll();
    void create(Question question);
    void delete(Question question);
    void deleteById(Integer id);
    Question readById(Integer id);
    void update(Question question);
}
