package com.netcracker.Service.UserService;

import com.netcracker.DAO.UserDAO.UserDAO;
import com.netcracker.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO dao;

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public User add(User user) {
        return dao.create(user);
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

    public User update(User user) {
        return dao.update(user);
    }

    public User readByUsername(String username) {
        return dao.readByUsername(username);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.readByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return buildUserFromEntity(user);
    }

    private org.springframework.security.core.userdetails.User buildUserFromEntity(User user) {
        String username = user.getLogin().trim();
        String password = user.getPassword().trim();

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (user.getAdmin()) authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(username, password, true, true, true, true, authorities);
    }
}
