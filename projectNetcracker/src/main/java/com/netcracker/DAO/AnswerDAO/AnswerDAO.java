package com.netcracker.DAO.AnswerDAO;

import com.netcracker.Entities.Answer;
import com.netcracker.Entities.Question;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getAll();
    Answer create(Answer answer);
    void delete(Answer answer);
    void deleteById(Integer id);
    Answer readById(Integer id);
    Answer update(Answer answer);
    List<Answer> getAnswers (Integer questId);
    void deleteAnswers(Integer questId);
}
