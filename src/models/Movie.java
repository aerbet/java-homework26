package models;

import java.util.ArrayList;
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

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Director getDirector() {
        return director;
    }

    public List<String> getActorName() {
        List<String> names = new ArrayList<>();

        for (Cast actor : cast) {
            names.add(actor.getFullName());
        }

        return names;
    }

    public List<Cast> getCast() {
        return cast;
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
