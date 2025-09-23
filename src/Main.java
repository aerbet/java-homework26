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

//        wrapper.sortByYear(movies);
//        wrapper.sortByName(movies);
//        wrapper.sortByDirector(movies);

        MovieConsole.printMovies(movies);

        MovieConsole.printSearchByName(wrapper.searchByName("harr"));

        MovieConsole.printActorMovies("Robert Downey Jr.", wrapper.searchActorMovies("Robert Downey Jr."));

        MovieConsole.printDirectorMovies("Peter Jackson", wrapper.searchDirectorMovies("Peter Jackson"));

        MovieConsole.printYearMovies(2010, wrapper.searchYearMovies(2010));

        List<ActorMovieRole> roles = wrapper.searchActorMoviesAndRole("Robert Downey Jr.");
        MovieConsole.printActorRoles("Robert Downey Jr.", roles);

        List<String> allActorInfo = wrapper.getAllActorsWithMoviesAndRoles();
        MovieConsole.printAllActorsWithMoviesAndRoles(allActorInfo);

        MovieConsole.printMovies(movies);
    }
}