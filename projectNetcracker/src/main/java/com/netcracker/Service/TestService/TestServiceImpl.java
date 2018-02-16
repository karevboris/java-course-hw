package com.netcracker.Service.TestService;

import com.netcracker.DAO.TestDAO.TestDAO;
import com.netcracker.Entities.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDAO dao;

    public void setDao(TestDAO dao) {
        this.dao = dao;
    }

    public Test add(Test test) {
        return dao.create(test);
    }

    public List<Test> getAll() {
        return dao.getAll();
    }

    public void delete(Test test) {
        dao.delete(test);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public Test readById(Integer id) {
        return dao.readById(id);
    }

    public Test update(Test test) {
        return dao.update(test);
    }

    public Test getLastTest(Integer userId) {
        Test test = new Test();
        for (Test t:getAll()){
            if(t.getUserId().equals(userId)) test = t;
        }
        return test;
    }
}
