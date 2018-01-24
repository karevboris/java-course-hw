package com.netcracker.Entities;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_tests")
@EnableTransactionManagement
public class UserTest implements Serializable{
    @Id
    @Column(name = "user_test_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "test_id")
    private Integer testId;

    public UserTest() {
    }

    public UserTest(Integer userId, Integer testId) {
        this.userId = userId;
        this.testId = testId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "id=" + id +
                ", userId=" + userId +
                ", testId=" + testId +
                '}';
    }
}
