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

    public void add(Test test) {
        dao.create(test);
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

    public void update(Test test) {
        dao.update(test);
    }
}
