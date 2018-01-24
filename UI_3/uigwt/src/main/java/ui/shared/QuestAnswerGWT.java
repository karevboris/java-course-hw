package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestAnswerGWT {
    private final Boolean isCorrect;
    private final Integer questId;
    private final Integer answerId;

    @JsonCreator
    public QuestAnswerGWT(@JsonProperty("isCorrect")Boolean isCorrect, @JsonProperty("questId")Integer questId, @JsonProperty("answerId")Integer answerId) {
        this.isCorrect = isCorrect;
        this.questId = questId;
        this.answerId = answerId;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public Integer getQuestId() {
        return questId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    @Override
    public String toString() {
        return "QuestAnswerGWT{" +
                "isCorrect=" + isCorrect +
                ", questId=" + questId +
                ", answerId=" + answerId +
                '}';
    }
}
