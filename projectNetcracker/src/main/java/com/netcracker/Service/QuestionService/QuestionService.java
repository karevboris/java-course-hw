package com.netcracker.Service.QuestionService;

import com.netcracker.Entities.Question;

import java.util.List;

public interface QuestionService {
    Question add(Question question);
    void delete(Question question);
    List<Question> getAll();
    void deleteById(Integer id);
    Question readById(Integer id);
    Question update(Question question);
}
