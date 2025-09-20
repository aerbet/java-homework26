import models.Movie;
import models.MoviesList;
import utils.FileUtil;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path path = FileUtil.getFilePath("movies");

        MoviesList wrapper = FileUtil.readMoviesFile(path);

        if (wrapper != null) {
            List<Movie> movies = wrapper.getMovies();

            for (Movie movie : movies) {
                System.out.println("Movie: " + movie.getName());
                System.out.println("Director: " + movie.getDirector().getFullName());
                System.out.println("------------------------------------------------");
            }
        }
    }
}