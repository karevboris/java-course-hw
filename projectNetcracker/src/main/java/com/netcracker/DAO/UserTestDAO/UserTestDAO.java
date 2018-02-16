package com.netcracker.DAO.UserTestDAO;

import com.netcracker.Entities.DetailTest;
import com.netcracker.Entities.Test;
import com.netcracker.Entities.User;
import com.netcracker.Entities.UserTest;

import java.util.List;

public interface UserTestDAO {
    List<UserTest> getAll();
    UserTest create(UserTest userTest);
    void delete(UserTest userTest);
    void deleteById(Integer id);
    UserTest readById(Integer id);
    UserTest read(Integer userId, Integer testId);
    UserTest update(UserTest userTest);
    List<Test> getTests(Integer userId);
    List<User> getUsers(Integer testId);
    DetailTest getDetailTest(UserTest userTest);
    void deleteTests(Integer userId);
    void deleteUsers(Integer testId);
    void deleteDetailTest(UserTest userTest);
}
