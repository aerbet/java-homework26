package models;

import java.util.List;
import java.util.Objects;

public class Movie {
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;

    public Movie() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        String castInfo = "";
        for (Cast c : cast) {
            castInfo += String.format("      %s%n", c);
        }

        return String.format(
                "Movie%n" +
                        "name: %s%n" +
                        "year: %d%n" +
                        "description: %s%n" +
                        "director: %s%n" +
                        "cast:%n%s",
                name, year, description, director.getFullName(), castInfo
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
