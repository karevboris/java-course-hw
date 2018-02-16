package com.netcracker.Service.UserService;

import com.netcracker.Entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User add(User user);
    void delete(User user);
    void deleteById(Integer id);
    User readById(Integer id);
    User update(User user);
    UserDetails loadUserByUsername(String username);
    User readByUsername(String username);
}
