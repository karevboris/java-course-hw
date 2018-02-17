package ui.client.View;

import com.google.gwt.user.client.ui.ListBox;

public class ResultAnswer {
    private Integer correct;
    private Integer questId;
    private ListBox answer;
    private Double result;
    private Double allPoints;
    private Integer passed;
    private Integer failed;

    public ResultAnswer() {
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public Integer getQuestId() {
        return questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    public ListBox getAnswer() {
        return answer;
    }

    public void setAnswer(ListBox answer) {
        this.answer = answer;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getAllPoints() {
        return allPoints;
    }

    public void setAllPoints(Double allPoints) {
        this.allPoints = allPoints;
    }

    public Integer getPassed() {
        return passed;
    }

    public void setPassed(Integer passed) {
        this.passed = passed;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultAnswer that = (ResultAnswer) o;

        if (correct != null ? !correct.equals(that.correct) : that.correct != null) return false;
        if (questId != null ? !questId.equals(that.questId) : that.questId != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (allPoints != null ? !allPoints.equals(that.allPoints) : that.allPoints != null) return false;
        if (passed != null ? !passed.equals(that.passed) : that.passed != null) return false;
        return failed != null ? failed.equals(that.failed) : that.failed == null;
    }

    @Override
    public int hashCode() {
        int result1 = correct != null ? correct.hashCode() : 0;
        result1 = 31 * result1 + (questId != null ? questId.hashCode() : 0);
        result1 = 31 * result1 + (answer != null ? answer.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (allPoints != null ? allPoints.hashCode() : 0);
        result1 = 31 * result1 + (passed != null ? passed.hashCode() : 0);
        result1 = 31 * result1 + (failed != null ? failed.hashCode() : 0);
        return result1;
    }
}
