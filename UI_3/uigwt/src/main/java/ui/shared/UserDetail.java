package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetail {
    private final Integer id;
    private final Integer testid;
    private final String name;
    private final Integer passed;
    private final Integer failed;
    private final Double result;
    private final Integer attempts;
    private final String date;

    @JsonCreator
    public UserDetail(@JsonProperty("id")Integer id, @JsonProperty("testid")Integer testid, @JsonProperty("name")String name, @JsonProperty("passed")Integer passed, @JsonProperty("failed")Integer failed, @JsonProperty("result")Double result, @JsonProperty("attempts")Integer attempts, @JsonProperty("date") String date) {
        this.id = id;
        this.testid = testid;
        this.name = name;
        this.passed = passed;
        this.failed = failed;
        this.result = result;
        this.attempts = attempts;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTestid() {
        return testid;
    }

    public String getName() {
        return name;
    }

    public Integer getPassed() {
        return passed;
    }

    public Integer getFailed() {
        return failed;
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
}
