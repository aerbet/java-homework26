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

        movies.forEach(System.out::println);

        System.out.println(wrapper.searchByName("harr"));

        Map<List<String>, String> mapWrapper = new HashMap<>();
        String fmt = "%s %s";

        for (Movie movie : movies) {
            mapWrapper.put(movie.getActorName(), movie.getName());
        }

        for (Map.Entry<List<String>, String> entry : mapWrapper.entrySet()) {
            String msg = String.format(fmt, entry.getKey(), entry.getValue());

            System.out.println(msg);
        }

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