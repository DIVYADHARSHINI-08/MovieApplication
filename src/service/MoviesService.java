package service;

import entity.Movies;
import java.util.HashMap;

public class MoviesService {

    // Key = movie title (lowercase)
    private HashMap<String, Movies> movies = new HashMap<>();

    // Constructor → manual data
    public MoviesService() {
        movies.put("leo", new Movies(1L, "Leo", 150, "Action", 2023, 8.5, 1L));
        movies.put("jailer", new Movies(2L, "Jailer", 160, "Action", 2023, 8.2, 1L));
        movies.put("dear comrade", new Movies(3L, "Dear Comrade", 180, "Romance&action", 2021, 9.5, 1L));
        movies.put("dio", new Movies(4L, "Dio", 200, "Thriller", 20222, 7.8, 1L));
    }

    // Add movie
    public void addMovie(Movies movie) {

        String key = movie.getTitle().toLowerCase();

        if (movies.containsKey(key)) {
            System.out.println("Movie already exists!");
            return;
        }

        movies.put(key, movie);
        System.out.println("Movie added!");
    }

    // Search movie
    public void searchMovie(String title) {

        String key = title.toLowerCase();

        if (movies.containsKey(key)) {
            System.out.println(movies.get(key));
        } else {
            System.out.println("Movie not found!");
        }
    }

    // Filter by genre
    public void filterByGenre(String genre) {

        boolean found = false;

        for (Movies m : movies.values()) {
            if (m.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(m);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No movies found!");
        }
    }

    // Trending
    public void showTrending() {

        boolean found = false;

        for (Movies m : movies.values()) {
            if (m.getRating() >= 8.0) {
                System.out.println(m);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No trending movies!");
        }
    }

    // Show all
    public void showAllMovies() {

        if (movies.isEmpty()) {
            System.out.println("No movies available!");
            return;
        }

        for (Movies m : movies.values()) {
            System.out.println(m);
        }
    }

    // Update
    public void updateMovie(String title, int duration, String genre, int year, double rating) {

        String key = title.toLowerCase();

        if (!movies.containsKey(key)) {
            System.out.println("Movie not found!");
            return;
        }

        Movies old = movies.get(key);

        Movies updated = new Movies(
                old.getMovieId(),
                old.getTitle(),
                duration,
                genre,
                year,
                rating,
                old.getUserId()
        );

        movies.put(key, updated);
        System.out.println("Movie updated!");
    }

    // Delete
    public void deleteMovie(String title) {

        String key = title.toLowerCase();

        if (movies.remove(key) != null) {
            System.out.println("Movie deleted!");
        } else {
            System.out.println("Movie not found!");
        }
    }
}