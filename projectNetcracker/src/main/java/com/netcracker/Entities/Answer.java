package com.netcracker.Entities;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answers")
@EnableTransactionManagement
public class Answer implements Serializable {
    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "text")
    private String text;

    public Answer() {
    }

    public Answer(String text) {
        this.text = text;
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

    @Override
    public String toString() {
        return "Answer:" +
                "id=" + id +
                ", text=" + text;
    }
}
