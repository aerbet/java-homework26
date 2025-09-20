package utils;

import models.Movie;
import java.util.List;

public interface Sortable {
    void sortByName(List<Movie> movies);
    void sortByYear(List<Movie> movies);
    void sortByDirector(List<Movie> movies);
}
