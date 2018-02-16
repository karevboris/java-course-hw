package com.netcracker.DAO.UserDAO;

import com.netcracker.Entities.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    User create(User user);
    void delete(User user);
    void deleteById(Integer id);
    User readById(Integer id);
    User readByUsername(String username);
    User update(User user);
}
