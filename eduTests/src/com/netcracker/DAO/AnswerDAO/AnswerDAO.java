package com.netcracker.DAO.AnswerDAO;

import com.netcracker.Entities.Answer;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getAll();
    void create(Answer answer);
    void delete(Answer answer);
    void deleteById(Integer id);
    Answer readById(Integer id);
    void update(Answer answer);
}
