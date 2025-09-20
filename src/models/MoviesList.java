package models;

import utils.Sortable;

import java.util.Comparator;
import java.util.List;

public class MoviesList implements Sortable {
    private List<Movie> movies;

    public MoviesList() {}

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public void sortByYear(List<Movie> movies) {
        movies.sort(Comparator.comparing(Movie::getYear));
    }

    @Override
    public void sortByName(List<Movie> movies) {
        movies.sort(Comparator.comparing(Movie::getName));
    }

    @Override
    public void sortByDirector(List<Movie> movies) {
        movies.sort(Comparator.comparing(movie -> movie.getDirector().getFullName()));
    }
}
