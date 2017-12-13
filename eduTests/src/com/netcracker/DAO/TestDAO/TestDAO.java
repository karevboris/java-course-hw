package com.netcracker.DAO.TestDAO;

import com.netcracker.Entities.Test;

import java.util.List;

public interface TestDAO {
    List<Test> getAll();
    void create(Test test);
    void delete(Test test);
    void deleteById(Integer id);
    Test readById(Integer id);
    void update(Test test);
}
