package models;

import java.util.Comparator;
import java.util.List;

public class MoviesList {
    private List<Movie> movies;

    public MoviesList() {}

    public List<Movie> getMovies() {
        return movies;
    }

    public void sortByYear() {
        getMovies().sort(Comparator.comparing(Movie::getYear));

        System.out.printf("%nMoviesList sorted by year: %n%s", getMovies());
    }

    public void sortByName() {
        getMovies().sort(Comparator.comparing(Movie::getName));

        System.out.printf("%nMoviesList sorted by name: %n%s", getMovies());
    }

    public void sortByDirector() {
        getMovies().sort(Comparator.comparing(movie -> movie.getDirector().getFullName()));

        System.out.printf("%nMoviesList sorted by director: %n%s", getMovies());
    }
}
