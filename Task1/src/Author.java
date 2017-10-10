/**
 * Created by Boris on 10.10.2017.
 */
public class Author {

    private String name;
    private String email;
    private char gender;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }
}
