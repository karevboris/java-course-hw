package com.netcracker.DAO.UserTestDAO;

import com.netcracker.Entities.UserTest;

import java.util.List;

public interface UserTestDAO {
    List<UserTest> getAll();
    void create(UserTest userTest);
    void delete(UserTest userTest);
    void deleteById(Integer id);
    UserTest readById(Integer id);
    void update(UserTest userTest);
}
