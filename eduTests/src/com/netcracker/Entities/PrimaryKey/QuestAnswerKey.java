package com.netcracker.Entities.PrimaryKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Table(name = "quest_answers")
public class QuestAnswerKey implements Serializable {

    @Column(name = "quest_id")
    private Integer questId;

    @Column(name = "answer_id")
    private Integer answerId;

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "QuestAnswerKey{" +
                "questId=" + questId +
                ", answerId=" + answerId +
                '}';
    }
}
