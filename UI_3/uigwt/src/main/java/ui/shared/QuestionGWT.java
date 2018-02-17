package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionGWT {
    private final Integer id;
    private final String text;
    private final Integer time;
    private final Double points;
    private Integer answer;

    @JsonCreator
    public QuestionGWT(@JsonProperty("id") Integer id, @JsonProperty("text")String text, @JsonProperty("time")Integer time, @JsonProperty("points")Double points) {
        this.id = id;
        this.text = text;
        this.time = time;
        this.points = points;
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

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionGWT{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionGWT that = (QuestionGWT) o;

        if (!id.equals(that.id)) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        return points != null ? points.equals(that.points) : that.points == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        return result;
    }
}
