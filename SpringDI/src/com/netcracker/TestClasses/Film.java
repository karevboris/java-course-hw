package com.netcracker.TestClasses;

public class Film {
    private Genre genre;

    public Film() {
        System.out.println("Film.Film");
    }

    public Film(Genre genre) {
        this.genre = genre;
        System.out.println("genre = " + genre);
    }

    public void setGenre(Genre genre) {
        System.out.println("Film.setGenre");
        this.genre = genre;
        System.out.println("genre = " + genre.getName());
    }
}
