package com.netcracker.Service.UserTestService;

import com.netcracker.Entities.UserTest;

import java.util.List;

public interface UserTestService {
    List<UserTest> getAll();
    void add(UserTest userTest);
    void delete(UserTest userTest);
    void deleteById(Integer id);
    UserTest readById(Integer id);
    void update(UserTest userTest);
}
