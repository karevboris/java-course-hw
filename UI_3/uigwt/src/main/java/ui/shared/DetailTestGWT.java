package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DetailTestGWT {
    private final Integer id;
    private final Integer countPassed;
    private final Integer countFailed;
    private final Double result;

    @JsonCreator
    public DetailTestGWT(@JsonProperty("id") Integer id, @JsonProperty("countPassed")Integer countPassed, @JsonProperty("countFailed")Integer countFailed,@JsonProperty("result") Double result) {
        this.id = id;
        this.countPassed = countPassed;
        this.countFailed = countFailed;
        this.result = result;
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

    @Override
    public String toString() {
        return "DetailTestGWT{" +
                "id=" + id +
                ", countPassed=" + countPassed +
                ", countFailed=" + countFailed +
                ", result=" + result +
                '}';
    }
}
