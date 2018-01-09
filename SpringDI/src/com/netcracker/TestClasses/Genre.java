package com.netcracker.TestClasses;

public class Genre {
    private String name;

    public Genre() {
        System.out.println("Genre.Genre");
    }

    public Genre(String name) {
        this.name = name;
        System.out.println("name = " + name);
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("name = " + name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
