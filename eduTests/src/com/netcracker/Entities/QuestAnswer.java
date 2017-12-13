package com.netcracker.Entities;

import com.netcracker.Entities.PrimaryKey.QuestAnswerKey;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;

@Entity
@Table(name = "quest_answers")
@EnableTransactionManagement
public class QuestAnswer {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private QuestAnswerKey id;

    @Column(name = "iscorrect")
    private Boolean isCorrect;

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
