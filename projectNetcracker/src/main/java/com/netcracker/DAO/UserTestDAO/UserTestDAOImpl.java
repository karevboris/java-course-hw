package com.netcracker.DAO.UserTestDAO;

import com.netcracker.DAO.AbstractDAO;
import com.netcracker.Entities.DetailTest;
import com.netcracker.Entities.Test;
import com.netcracker.Entities.User;
import com.netcracker.Entities.UserTest;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserTestDAOImpl extends AbstractDAO<UserTest> implements UserTestDAO {
    public List<UserTest> getAll() {
        CriteriaQuery<UserTest> criteriaQuery = getSession().getCriteriaBuilder().createQuery(UserTest.class);
        criteriaQuery.from(UserTest.class);
        return getSession().createQuery(criteriaQuery).getResultList();
    }

    public UserTest create(UserTest userTest) {
        persist(userTest);
        return userTest;
    }

    public void delete(UserTest userTest) {
        deleteEntity(userTest);
    }

    public void deleteById(Integer id) {
        delete(readById(id));
    }

    public UserTest readById(Integer id) {
        return (UserTest)getSession().get(UserTest.class, id);
    }

    public UserTest update(UserTest userTest) {
        updateEntity(userTest);
        return userTest;
    }

    public List<Test> getTests(Integer userId) {
        String query = "select * from tests where tests.test_id in (select test_id from user_tests where user_tests.user_id=:userId)";
        return getSession().createSQLQuery(query).addEntity(Test.class).setParameter("userId", userId).getResultList();
    }

    public List<User> getUsers(Integer testId) {
        String query = "select * from users where users.user_id in (select user_id from user_tests where user_tests.test_id=:testId)";
        return getSession().createSQLQuery(query).addEntity(User.class).setParameter("testId", testId).getResultList();
    }

    public DetailTest getDetailTest(UserTest userTest) {
        String query = "select * from detail_test where detail_test.user_test_id = (select user_tests.user_test_id from user_tests where user_tests.user_id=:userId and user_tests.test_id=:testId)";
        return (DetailTest)getSession().createSQLQuery(query).addEntity(DetailTest.class).setParameter("userId", userTest.getUserId()).setParameter("testId", userTest.getTestId()).getResultList().get(0);
    }

    public void deleteTests(Integer userId) {
        for(Test test:getTests(userId)){
            Integer id = getDetailTest(new UserTest(userId, test.getId())).getId();
            deleteDetailTest(new UserTest(userId, test.getId()));
            deleteById(id);
        }
    }

    public void deleteUsers(Integer testId) {
        for(User user:getUsers(testId)){
            Integer id = getDetailTest(new UserTest(user.getId(), testId)).getId();
            deleteDetailTest(new UserTest(user.getId(), testId));
            deleteById(id);
        }
    }

    public void deleteDetailTest(UserTest userTest) {
        String query = "delete from detail_test where detail_test.user_test_id = (select user_tests.user_test_id from user_tests where user_tests.user_id=:userId and user_tests.test_id=:testId)";
        getSession().createSQLQuery(query).addEntity(DetailTest.class).setParameter("userId", userTest.getUserId()).setParameter("testId", userTest.getTestId()).executeUpdate();
    }

    public UserTest read(Integer userId, Integer testId) {
        String query = "select * from user_tests where user_tests.user_id =:userId and user_tests.test_id=:testId";
        return (UserTest) getSession().createSQLQuery(query).addEntity(UserTest.class).setParameter("userId", userId).setParameter("testId", testId).getResultList().get(0);
    }
}
