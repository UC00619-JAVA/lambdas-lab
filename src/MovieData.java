import java.util.ArrayList;
import java.util.List;

public class MovieData {

  // sample data used in all the exercises
  public static List<Movie> load() {
    List<Movie> movies = new ArrayList<>();
    movies.add(new Movie("Inception", "Sci-Fi", 2010, 8.8, 148));
    movies.add(new Movie("Interstellar", "Sci-Fi", 2014, 8.7, 169));
    movies.add(new Movie("Parasite", "Thriller", 2019, 8.5, 132));
    movies.add(new Movie("Joker", "Drama", 2019, 8.4, 122));
    movies.add(new Movie("Dune", "Sci-Fi", 2021, 8.0, 155));
    movies.add(new Movie("Barbie", "Comedy", 2023, 6.8, 114));
    movies.add(new Movie("The Matrix", "Sci-Fi", 1999, 8.7, 136));
    movies.add(new Movie("Coco", "Animation", 2017, 8.4, 105));
    return movies;
  }
}
