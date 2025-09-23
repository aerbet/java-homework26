import models.ActorMovieRole;
import models.Movie;

import java.util.List;

public class MovieConsole {
    public MovieConsole() {}

    public static void printMovies(List<Movie> movies) {
        print("===== Список фильмов =====");
        movies.forEach(System.out::println);
        System.out.println();
    }

    public static void printSearchByName(List<String> movies) {
        print("===== Результат поиска по названию =====");
        System.out.println(movies);
        print("\n");
    }

    public static void printActorMovies(String actor, List<String> movies) {
        System.out.printf("%nФильмы, в которых снимался(ась) %s: %s%n", actor, movies);
    }

    public static void printDirectorMovies(String director, List<String> movies) {
        System.out.printf("%nФильмы, которые снял %s: %s%n", director, movies);
    }

    public static void printYearMovies(int year, List<String> movies) {
        System.out.printf("%nФильмы %d года выпуска: %s%n", year, movies);
        System.out.println();
    }

    public static void printActorRoles(String actor, List<ActorMovieRole> roles) {
        print("===== Роли актёра " + actor + " =====");
        String fmt = "Фильм: %-43s | Роль: %s%n";
        for (ActorMovieRole role : roles) {
            System.out.printf(fmt, role.getMovieName(), role.getRole());
        }
        System.out.println();
    }

    public static void printAllActorsWithMoviesAndRoles(List<String> allActorInfo) {
        print("===== Все актёры с фильмами и ролями =====");
        for (String actorInfo : allActorInfo) {
            print(actorInfo);
            print("---------------------------------------------------");
        }
        System.out.println();
    }

    public static void print(String str) {
        System.out.println(str);
    }
}
