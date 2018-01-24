package com.netcracker.Entities.PrimaryKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Table(name = "test_quest")
public class TestQuestKey implements Serializable {

    @Column(name = "quest_id")
    private Integer questId;

    @Column(name = "test_id")
    private Integer testId;

    public TestQuestKey() {
    }

    public TestQuestKey(Integer questId, Integer testId) {
        this.questId = questId;
        this.testId = testId;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "TestQuestKey{" +
                "questId=" + questId +
                ", testId=" + testId +
                '}';
    }
}
