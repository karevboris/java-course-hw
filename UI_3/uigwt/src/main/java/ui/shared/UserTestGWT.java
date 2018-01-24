package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserTestGWT {
    private final Integer id;
    private final Integer userId;
    private final Integer testId;

    @JsonCreator
    public UserTestGWT(@JsonProperty("id") Integer id, @JsonProperty("userId")Integer userId, @JsonProperty("testId")Integer testId) {
        this.id = id;
        this.userId = userId;
        this.testId = testId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getTestId() {
        return testId;
    }

    @Override
    public String toString() {
        return "UserTestGWT{" +
                "id=" + id +
                ", userId=" + userId +
                ", testId=" + testId +
                '}';
    }
}
