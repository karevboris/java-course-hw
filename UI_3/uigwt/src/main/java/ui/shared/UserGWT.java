package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserGWT {
    private final Integer id;
    private final String login;
    private final String password;
    private final Boolean isAdmin;

    @JsonCreator
    public UserGWT(@JsonProperty("id") Integer id, @JsonProperty("login")String login, @JsonProperty("password")String password, @JsonProperty("isAdmin")Boolean isAdmin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
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
        return isAdmin;
    }

    @Override
    public String toString() {
        return "UserGWT{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
