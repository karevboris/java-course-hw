package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestGWT {
    private final Integer id;
    private final String name;
    private final Integer userId;

    @JsonCreator
    public TestGWT(@JsonProperty("id")Integer id, @JsonProperty("name")String name, @JsonProperty("userId")Integer userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "TestGWT{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}

