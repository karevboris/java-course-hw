package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerGWT {
    private final Integer id;
    private final String text;

    @JsonCreator
    public AnswerGWT(@JsonProperty("id") Integer id, @JsonProperty("text") String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "AnswerClient{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
