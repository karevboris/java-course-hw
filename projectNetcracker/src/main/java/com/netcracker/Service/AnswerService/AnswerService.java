package com.netcracker.Service.AnswerService;

import com.netcracker.Entities.Answer;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AnswerService {
    Answer add(Answer answer);
    void delete(Answer answer);
    List<Answer> getAll();
    void deleteById(Integer id);
    Answer readById(Integer id);
    Answer update(Answer answer);
    List<Answer> getAnswers(Integer questId);
    void deleteAnswers(Integer questId);
}
