import models.Movie;
import models.MoviesList;
import utils.FileUtil;

import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Path path = FileUtil.getFilePath("movies");

        MoviesList wrapper = FileUtil.readMoviesFile(path);
        List<Movie> movies = wrapper.getMovies();

        wrapper.sortByYear(movies);
//        movies.forEach(System.out::println);

        System.out.println(wrapper.searchByName("harr"));

/*        while (true) {
            System.out.printf("Поиск по названию фильма: ");
            String name = new Scanner(System.in).nextLine();

            List<String> movieNames = new ArrayList<>();

            for (Movie movie : movies) {
                if (movie.getName().toLowerCase().contains(name.toLowerCase())) {
                    movieNames.add(movie.getName().toLowerCase());
                }
            }

            System.out.println(movieNames);
        }*/
    }
}