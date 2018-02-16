package com.netcracker.Service.UserTestService;

import com.netcracker.DAO.UserTestDAO.UserTestDAO;
import com.netcracker.Entities.DetailTest;
import com.netcracker.Entities.Test;
import com.netcracker.Entities.User;
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

    public UserTest add(UserTest userTest) {
        return dao.create(userTest);
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

    public UserTest update(UserTest userTest) {
        return dao.update(userTest);
    }

    public List<User> getUsers(Integer testId) {
        return dao.getUsers(testId);
    }

    public List<Test> getTests(Integer userId) {
        return dao.getTests(userId);
    }

    public DetailTest getDetailTest(UserTest userTest) {
        return dao.getDetailTest(userTest);
    }

    public Integer getCountTests(Integer userId) {
        return getTests(userId).size();
    }

    public Integer getCountPassedTests(Integer userId){
        Integer count=0;
        List<Test> tests = getTests(userId);
        for(Test test:tests){
            DetailTest detailTest = getDetailTest(new UserTest(userId, test.getId()));
            if (detailTest.getCountFailed()>0||detailTest.getCountPassed()>0) count++;
        }
        return count;
    }

    public Double getPercentPassedTests(Integer userId) {
        Integer count=0;
        Double res=0.0;
        List<Test> tests = getTests(userId);
        for(Test test:tests){
            DetailTest detailTest = getDetailTest(new UserTest(userId, test.getId()));
            count+=detailTest.getCountFailed()+detailTest.getCountPassed();
            res+=detailTest.getCountPassed();
        }
        return res/count*100;
    }

    public Integer getCountUsers(Integer testId) {
        return getUsers(testId).size();
    }

    public Integer getCountPassedUsers(Integer testId) {
        Integer count=0;
        List<User> users = getUsers(testId);
        for(User user:users){
            DetailTest detailTest = getDetailTest(new UserTest(user.getId(), testId));
            if (detailTest.getCountFailed()>0||detailTest.getCountPassed()>0) count++;
        }
        return count;
    }

    public Double getPercentPassedUsers(Integer testId) {
        Integer count=0;
        Double res=0.0;
        List<User> users = getUsers(testId);
        for(User user:users){
            DetailTest detailTest = getDetailTest(new UserTest(user.getId(), testId));
            count+=detailTest.getCountFailed()+detailTest.getCountPassed();
            res+=detailTest.getCountPassed();
        }
        return res/count*100;
    }

    public void deleteTests(Integer userId) {
        dao.deleteTests(userId);
    }

    public void deleteUsers(Integer testId) {
        dao.deleteUsers(testId);
    }

    public void deleteDetailTest(UserTest userTest) {
        dao.deleteDetailTest(userTest);
    }

    public UserTest read(Integer userId, Integer testId) {
        return dao.read(userId, testId);
    }
}
