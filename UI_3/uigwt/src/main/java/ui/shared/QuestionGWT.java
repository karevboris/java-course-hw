package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionGWT {
    private final Integer id;
    private final String text;
    private final Integer time;
    private final Double points;
    private final Integer userId;

    @JsonCreator
    public QuestionGWT(@JsonProperty("id") Integer id, @JsonProperty("text")String text, @JsonProperty("time")Integer time, @JsonProperty("points")Double points, @JsonProperty("userId")Integer userId) {
        this.id = id;
        this.text = text;
        this.time = time;
        this.points = points;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getTime() {
        return time;
    }

    public Double getPoints() {
        return points;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "QuestionGWT{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", points=" + points +
                ", userId=" + userId +
                '}';
    }
}
