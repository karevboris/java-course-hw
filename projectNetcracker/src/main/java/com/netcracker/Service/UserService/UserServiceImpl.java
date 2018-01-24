package com.netcracker.Service.UserService;

import com.netcracker.DAO.UserDAO.UserDAO;
import com.netcracker.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO dao;

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public void add(User user) {
        dao.create(user);
    }

    public List<User> getAll() {
        return dao.getAll();
    }

    public void delete(User test) {
        dao.delete(test);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public User readById(Integer id) {
        return dao.readById(id);
    }

    public void update(User user) {
        dao.update(user);
    }
}
