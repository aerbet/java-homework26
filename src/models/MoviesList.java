package models;

import utils.Searchable;
import utils.Sortable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MoviesList implements Sortable, Searchable {
    private List<Movie> movies;

    public MoviesList() {}

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public List<String> searchByName(String name) {
        List<String> movieNames = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().contains(name.toLowerCase())) {
                movieNames.add(movie.getName().toLowerCase());
            }
        }

        return movieNames;
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
