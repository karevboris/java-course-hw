package com.netcracker.Service.TestService;

import com.netcracker.Entities.Test;

import java.util.List;

public interface TestService {
    Test add(Test test);
    void delete(Test test);
    List<Test> getAll();
    void deleteById(Integer id);
    Test readById(Integer id);
    Test update(Test test);
    Test getLastTest(Integer userId);
}
