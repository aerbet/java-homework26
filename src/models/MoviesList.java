package models;

import utils.Searchable;
import utils.Sortable;

import java.util.*;

public class MoviesList implements Sortable, Searchable {
    private List<Movie> movies;
    private final Map<String, List<String>> actorMoviesMap = new HashMap<>();
    private final Map<String, List<String>> directorMoviesMap = new HashMap<>();
    private final Map<Integer, List<String>> yearMoviesMap = new HashMap<>();
    private final Map<String, List<ActorMovieRole>> roleAndMoviesMap = new HashMap<>();

    public MoviesList() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public List<ActorMovieRole> searchActorMoviesAndRole(String name) {
        for (Movie movie : movies) {
            for (Cast cast : movie.getCast()) {
                String castActorName = cast.getFullName().toLowerCase().trim();

                roleAndMoviesMap.computeIfAbsent(castActorName, k -> new ArrayList<>()).add(new ActorMovieRole(movie.getName(), cast.getRole()));
            }
        }

        return roleAndMoviesMap.getOrDefault(name, new ArrayList<>());
    }

    @Override
    public List<String> searchYearMovies(int year) {
        for (Movie movie : movies) {
            int currentYear = movie.getYear();

            yearMoviesMap.computeIfAbsent(currentYear, k -> new ArrayList<>()).add(movie.getName());
        }

        return yearMoviesMap.computeIfAbsent(year, k -> new ArrayList<>());
    }

    @Override
    public List<String> searchDirectorMovies(String directorName) {
        for (Movie movie : movies) {
            String currentDirectorName = movie.getDirector().getFullName().toLowerCase().trim();

            directorMoviesMap.computeIfAbsent(currentDirectorName, k -> new ArrayList<>()).add(movie.getName());
        }

        return directorMoviesMap.computeIfAbsent(directorName.toLowerCase().trim(), k -> new ArrayList<>());
    }

    @Override
    public List<String> searchActorMovies(String actorName) {
        for (Movie movie : movies) {
            for (Cast cast : movie.getCast()) {
                String castActorName = cast.getFullName().toLowerCase().trim();

                actorMoviesMap.computeIfAbsent(castActorName, k -> new ArrayList<>()).add(movie.getName());
            }
        }

        return actorMoviesMap.computeIfAbsent(actorName.toLowerCase().trim(), k -> new ArrayList<>());
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
