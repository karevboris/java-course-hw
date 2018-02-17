package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserGWT {
    private final Integer id;
    private final String login;
    private final String password;
    private final Boolean admin;
    private Integer count;
    private Integer passed;
    private Double percent;

    @JsonCreator
    public UserGWT(@JsonProperty("id") Integer id, @JsonProperty("login")String login, @JsonProperty("password")String password, @JsonProperty("admin")Boolean admin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPassed() {
        return passed;
    }

    public void setPassed(Integer passed) {
        this.passed = passed;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "UserGWT{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGWT userGWT = (UserGWT) o;

        if (!id.equals(userGWT.id)) return false;
        if (login != null ? !login.equals(userGWT.login) : userGWT.login != null) return false;
        if (password != null ? !password.equals(userGWT.password) : userGWT.password != null) return false;
        return admin.equals(userGWT.admin);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + admin.hashCode();
        return result;
    }
}
