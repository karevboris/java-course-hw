package com.netcracker.Service.UserService;

import com.netcracker.Entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void add(User user);
    void delete(User user);
    void deleteById(Integer id);
    User readById(Integer id);
    void update(User user);
}
