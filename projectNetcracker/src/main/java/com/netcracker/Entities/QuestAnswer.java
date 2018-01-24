package com.netcracker.Entities;

import com.netcracker.Entities.PrimaryKey.QuestAnswerKey;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quest_answers")
@EnableTransactionManagement
public class QuestAnswer implements Serializable {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private QuestAnswerKey id;

    @Column(name = "iscorrect")
    private Boolean isCorrect;

    public QuestAnswer() {
    }

    public QuestAnswer(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public QuestAnswerKey getId() {
        return id;
    }

    public void setId(QuestAnswerKey id) {
        this.id = id;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "QuestAnswer{" +
                "id=" + id +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
