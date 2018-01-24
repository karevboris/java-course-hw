package com.netcracker.Entities;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "questions")
@EnableTransactionManagement
public class Question implements Serializable {
    @Id
    @Column(name = "quest_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "time")
    private Integer time;

    @Column(name = "points")
    private Double points;

    @Column(name = "user_id")
    private Integer userId;

    public Question() {
    }

    public Question(String text, Integer time, Double points, Integer userId) {
        this.text = text;
        this.time = time;
        this.points = points;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUser_id(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", points=" + points +
                ", user_id=" + userId +
                '}';
    }
}
