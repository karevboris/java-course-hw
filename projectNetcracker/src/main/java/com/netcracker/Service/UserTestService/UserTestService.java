package com.netcracker.Service.UserTestService;

import com.netcracker.Entities.DetailTest;
import com.netcracker.Entities.Test;
import com.netcracker.Entities.User;
import com.netcracker.Entities.UserTest;

import java.util.List;

public interface UserTestService {
    List<UserTest> getAll();
    UserTest add(UserTest userTest);
    void delete(UserTest userTest);
    void deleteById(Integer id);
    UserTest readById(Integer id);
    UserTest read(Integer userId, Integer testId);
    UserTest update(UserTest userTest);
    List<User> getUsers(Integer testId);
    List<Test> getTests(Integer userId);
    DetailTest getDetailTest(UserTest userTest);
    Integer getCountTests (Integer userId);
    Integer getCountPassedTests (Integer userId);
    Double getPercentPassedTests(Integer userId);
    Integer getCountUsers (Integer testId);
    Integer getCountPassedUsers (Integer testId);
    Double getPercentPassedUsers(Integer testId);
    void deleteTests(Integer userId);
    void deleteUsers(Integer testId);
    void deleteDetailTest(UserTest userTest);
}
