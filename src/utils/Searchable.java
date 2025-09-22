package utils;

import models.ActorMovieRole;

import java.util.List;
import java.util.Map;

public interface Searchable {
    List<String> searchByName(String name);
    List<String> searchActorMovies(String name);
    List<String> searchDirectorMovies(String name);
    List<String> searchYearMovies(int year);
    List<ActorMovieRole> searchActorMoviesAndRole(String name);
}
