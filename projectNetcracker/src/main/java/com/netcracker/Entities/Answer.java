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
    @SequenceGenerator(name = "answer", sequenceName = "answer_seq", allocationSize = 1)
    @GeneratedValue(generator = "answer", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "iscorrect")
    private Boolean isCorrect;

    @Column(name = "quest_id")
    private Integer questId;

    public Answer() {
    }

    public Answer(String text, Boolean isCorrect, Integer questId) {
        this.text = text;
        this.isCorrect = isCorrect;
        this.questId = questId;
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

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                ", questId=" + questId +
                '}';
    }
}
