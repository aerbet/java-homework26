package models;

public class ActorMovieRole {
    String movieName;
    String role;
    public ActorMovieRole(String movieName, String role) {
        this.movieName = movieName;
        this.role = role;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return movieName + " (" + role + ")";
    }
}
