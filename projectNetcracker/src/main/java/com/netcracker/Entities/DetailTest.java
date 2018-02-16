package com.netcracker.Entities;

import org.hibernate.type.DateType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "detail_test")
@EnableTransactionManagement
public class DetailTest implements Serializable{
    @Id
    @Column(name = "user_test_id")
    @SequenceGenerator(name = "detail", sequenceName = "detail_seq", allocationSize = 1)
    @GeneratedValue(generator = "detail", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "count_passed")
    private Integer countPassed;

    @Column(name = "count_failed")
    private Integer countFailed;

    @Column(name = "result")
    private Double result;

    @Column(name = "attempts")
    private Integer attempts;

    @Column(name = "date")
    private Date date;

    public DetailTest() {
    }

    public DetailTest(Integer countPassed, Integer countFailed, Double result, Integer attempts, Date date) {
        this.countPassed = countPassed;
        this.countFailed = countFailed;
        this.result = result;
        this.attempts = attempts;
        this.date = date;
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

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DetailTest{" +
                "id=" + id +
                ", countPassed=" + countPassed +
                ", countFailed=" + countFailed +
                ", result=" + result +
                ", attempts=" + attempts +
                ", date=" + date +
                '}';
    }
}
