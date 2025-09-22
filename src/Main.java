import models.ActorMovieRole;
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

        String fmt = "%nФильмы в которых снимался(ась): %s";
        System.out.printf(fmt, wrapper.searchActorMovies("Robert Downey Jr."));

        String fmt2 = "%nФильмы которые снимал: %s";
        System.out.printf(fmt2, wrapper.searchDirectorMovies("Peter Jackson"));

        String fmt3 = "%nФильм по введеному году выпуска: %s";
        System.out.printf(fmt3, wrapper.searchYearMovies(2010));

        List<ActorMovieRole> roles = wrapper.searchActorMoviesAndRole("Orlando Bloom");
        for (ActorMovieRole role : roles) {
            System.out.println("Фильм: " + role.getMovieName() + "Роль: " + role.getRole());
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