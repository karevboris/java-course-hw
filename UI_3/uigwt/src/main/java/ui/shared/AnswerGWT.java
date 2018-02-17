package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerGWT {
    private final Integer id;
    private final String text;
    private final Boolean correct;
    private final Integer questId;

    @JsonCreator
    public AnswerGWT(@JsonProperty("id") Integer id, @JsonProperty("text") String text,
                     @JsonProperty("correct")Boolean correct, @JsonProperty("questId")Integer questId) {
        this.id = id;
        this.text = text;
        this.correct = correct;
        this.questId = questId;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public Integer getQuestId() {
        return questId;
    }

    @Override
    public String toString() {
        return "AnswerGWT{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", correct=" + correct +
                ", questId=" + questId +
                '}';
    }
}
