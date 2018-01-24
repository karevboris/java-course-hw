package com.netcracker.Entities;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detail_test")
@EnableTransactionManagement
public class DetailTest implements Serializable{
    @Id
    @Column(name = "user_test_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "count_passed")
    private Integer countPassed;

    @Column(name = "count_failed")
    private Integer countFailed;

    @Column(name = "result")
    private Double result;

    public DetailTest() {
    }

    public DetailTest(Integer countPassed, Integer countFailed, Double result) {
        this.countPassed = countPassed;
        this.countFailed = countFailed;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountPassed() {
        return countPassed;
    }

    public void setCountPassed(Integer countPassed) {
        this.countPassed = countPassed;
    }

    public Integer getCountFailed() {
        return countFailed;
    }

    public void setCountFailed(Integer countFailed) {
        this.countFailed = countFailed;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DetailTestService{" +
                "id=" + id +
                ", countPassed=" + countPassed +
                ", countFailed=" + countFailed +
                ", result=" + result +
                '}';
    }
}
