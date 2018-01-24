package com.netcracker.Service.UserTestService;

import com.netcracker.DAO.UserTestDAO.UserTestDAO;
import com.netcracker.Entities.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserTestServiceImpl implements UserTestService {
    @Autowired
    private UserTestDAO dao;

    public void setDao(UserTestDAO dao) {
        this.dao = dao;
    }

    public void add(UserTest userTest) {
        dao.create(userTest);
    }

    public List<UserTest> getAll() {
        return dao.getAll();
    }

    public void delete(UserTest userTest) {
        dao.delete(userTest);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public UserTest readById(Integer id) {
        return dao.readById(id);
    }

    public void update(UserTest userTest) {
        dao.update(userTest);
    }
}
