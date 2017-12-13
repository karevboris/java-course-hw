package com.netcracker.Service.AnswerService;

import com.netcracker.Entities.Answer;

import java.util.List;

public interface AnswerService {
    void add(Answer answer);
    void delete(Answer answer);
    List<Answer> getAll();
    void deleteById(Integer id);
    Answer readById(Integer id);
    void update(Answer answer);
}
