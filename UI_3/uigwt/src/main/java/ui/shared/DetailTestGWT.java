package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DetailTestGWT {
    private final Integer id;
    private final Integer countPassed;
    private final Integer countFailed;
    private final Double result;
    private final Integer attempts;
    private final String date;
    private String name;

    @JsonCreator
    public DetailTestGWT(@JsonProperty("id") Integer id, @JsonProperty("countPassed")Integer countPassed, @JsonProperty("countFailed")Integer countFailed,@JsonProperty("result") Double result, @JsonProperty("attempts") Integer attempts, @JsonProperty("date") String date) {
        this.id = id;
        this.countPassed = countPassed;
        this.countFailed = countFailed;
        this.result = result;
        this.attempts = attempts;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCountPassed() {
        return countPassed;
    }

    public Integer getCountFailed() {
        return countFailed;
    }

    public Double getResult() {
        return result;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DetailTestGWT{" +
                "id=" + id +
                ", countPassed=" + countPassed +
                ", countFailed=" + countFailed +
                ", result=" + result +
                ", attempts=" + attempts +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
