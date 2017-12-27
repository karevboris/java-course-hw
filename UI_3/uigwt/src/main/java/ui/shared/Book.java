package ui.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Book {

    private final int id;
    private final String name;
    private final int numPages;
    private final String author;
    private final int datePublhn;
    private final String date;


    @JsonCreator
    public Book(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("numPages") int numPages,
                @JsonProperty("author") String author, @JsonProperty("datePublhn") int datePublhn, @JsonProperty("date") String date) {
        this.id = id;
        this.name = name;
        this.numPages = numPages;
        this.author = author;
        this.datePublhn = datePublhn;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getNumPages() {
        return numPages;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public int getDatePublhn() {
        return datePublhn;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return ""+id + '*' + name + '*' + numPages + '*' + author + '*' + datePublhn + '*' + date +'\n';
    }
}
