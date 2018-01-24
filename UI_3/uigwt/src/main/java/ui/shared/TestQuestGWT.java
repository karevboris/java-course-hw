package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestQuestGWT {
    private final Integer questId;
    private final Integer testId;

    @JsonCreator
    public TestQuestGWT(@JsonProperty("questId") Integer questId, @JsonProperty("testId") Integer testId) {
        this.questId = questId;
        this.testId = testId;
    }

    public Integer getQuestId() {
        return questId;
    }

    public Integer getTestId() {
        return testId;
    }

    @Override
    public String toString() {
        return "TestQuestGWT{" +
                "questId=" + questId +
                ", testId=" + testId +
                '}';
    }
}
